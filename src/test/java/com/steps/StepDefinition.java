package com.steps;

import com.spec.WeatherInformation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.response.DaysInformation.getThursdayAndFridayInTheNext16Days;
import static com.response.ResponseInformation.*;

public class StepDefinition {

    public static HashMap<String, String> testData = new HashMap<>();
    public static HashMap<String, Response> response = new HashMap<>();

    public static List weatherInformationList;
    public static List<WeatherInformation> weatherInformationObjects = new ArrayList<>();
    public static List<WeatherInformation> filteredWeatherObjects = new ArrayList<>();
    public static List<WeatherInformation> finalWeatherObjectsList = new ArrayList<>();
    public static List<LocalDate> days = new ArrayList<>();

    @Given("^I aim to surf in a beach in Sydney having country code as \"([^\"]*)\"$")
    public void iAimToSurfInABeachInSydneyHavingCountryCodeAs(String countryCode) {
        testData.put("countryCode",countryCode);
    }

    @And("^I only like to surf on any two days specifically \"([^\"]*)\" and \"([^\"]*)\" in next (\\d+) Days$")
    public void iOnlyLikeToSurfOnAnyTwoDaysSpecificallyAndInNextDays(String firstDay, String secondDay, int totalNumberOfDays) {
        testData.put("firstDay",firstDay);
        testData.put("secondDay",secondDay);
        testData.put("totalNumberOfDays",String.valueOf(totalNumberOfDays));
    }

    @When("^I look up the the weather forecast for the next (\\d+) days using POSTAL CODE \"([^\"]*)\"$")
    public void iLookUpTheTheWeatherForecastForTheNextDaysUsingPOSTALCODE(int totalNumberOfDays, String postalCode) {
        testData.put("postalCode",postalCode);
        response.put("response",getWeatherApiResponse());
        weatherInformationList = getWeatherApiResponse().jsonPath().get("data");
        Assert.assertTrue(weatherInformationList.size() == 16);
        setWeatherInformation(weatherInformationList,response.get("response"));
    }

    @Then("^I check to if see the temperature is between \"([^\"]*)\" and \"([^\"]*)\" and UV index is <= (\\d+)$")
    public void iCheckToIfSeeTheTemperatureIsBetweenAndAndUVIndexIs(String minimumTemperature, String maximumTemperature, int uvIndex)  {
        testData.put("minimumTemperature",minimumTemperature);
        testData.put("maximumTemperature",maximumTemperature);
        testData.put("uvIndex",String.valueOf(uvIndex));
        Predicate<WeatherInformation> getTemperature = e -> (e.getMinimumTemperature() > Integer.parseInt(minimumTemperature.split("°")[0]) && e.getMaximumTemperature() < Integer.parseInt(maximumTemperature.split("°")[0])) ;
        Predicate<WeatherInformation> getUV = e -> e.getMaximumUV() <= uvIndex;
        filteredWeatherObjects = weatherInformationObjects
                .stream()
                .filter(getTemperature.and(getUV))
                .collect(Collectors.toList());
        getThursdayAndFridayInTheNext16Days();

        for (LocalDate day : days) {
            for (WeatherInformation weatherInformation : filteredWeatherObjects) {
                if (day.toString().contentEquals(weatherInformation.getValidDate())) {
                    finalWeatherObjectsList.add(weatherInformation);
                }
            }

        }
    }

    @And("^I Pick two spots based on suitable weather forecast for the day$")
    public void iPickTwoSpotsBasedOnSuitableWeatherForecastForTheDay() {
        if(finalWeatherObjectsList.size() ==0){
            System.out.println("No beaches suitable to surf based on the weather criteria");
        }
        else{
            for (WeatherInformation weatherInformation : finalWeatherObjectsList) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(weatherInformation.getValidDate(), formatter);
                Assert.assertTrue(localDate.getDayOfWeek().toString().equalsIgnoreCase(testData.get("firstDay")) || localDate.getDayOfWeek().toString().equalsIgnoreCase(testData.get("secondDay")));
                Assert.assertTrue(weatherInformation.getMinimumTemperature() > Integer.parseInt(testData.get("minimumTemperature").split("°")[0]) && weatherInformation.getMaximumTemperature() < Integer.parseInt(testData.get("maximumTemperature").split("°")[0]));
                Assert.assertTrue(weatherInformation.getMaximumUV() <= Integer.parseInt(testData.get("uvIndex")));
            }
            System.out.println("Surfing spot found based on the weather criteria");
        }

    }



}
