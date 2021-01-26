package com.response;

import com.spec.WeatherInformation;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static com.steps.StepDefinition.*;
import static com.utils.UtilConstants.getApiKey;
import static com.utils.UtilConstants.getBaseUrl;
import static io.restassured.RestAssured.given;

public class ResponseInformation {

    public static Response getWeatherApiResponse(){
        Response response =  given()
                .params("country", testData.get("countryCode"))
                .params("postal_code", Integer.parseInt(testData.get("postalCode")))
                .params("key", getApiKey())
                .when().
                log().all().
                 get(getBaseUrl()).then().
                contentType(ContentType.JSON).
                extract().response();
        return response;
    }

    public static void setWeatherInformation(List weatherInformationList,Response response){
        for (int i = 0; i < weatherInformationList.size(); i++) {
            WeatherInformation weatherInformation = new WeatherInformation();
            weatherInformation.setValidDate(response.jsonPath().get(String.format("data[%s].valid_date",i)));
            weatherInformation.setMaximumUV(response.jsonPath().get(String.format("data[%s].uv",i)));

            var valueLowTemperature = response.jsonPath().get(String.format("data[%s].low_temp",i));
            if (valueLowTemperature.getClass() == Integer.class) {
                Integer lowTemperatureInteger = (Integer) valueLowTemperature;
                weatherInformation.setMinimumTemperature(lowTemperatureInteger.floatValue() );
            }
            else{
                weatherInformation.setMinimumTemperature(response.jsonPath().get(String.format("data[%s].low_temp",i)));
            }

            var valueMaximumTemperature = response.jsonPath().get(String.format("data[%s].max_temp",i));
            if (valueMaximumTemperature.getClass() == Integer.class) {
                Integer maximumTemperatureInteger = (Integer) valueMaximumTemperature;
                weatherInformation.setMaximumTemperature(maximumTemperatureInteger.floatValue() );
            }
            else{
                weatherInformation.setMaximumTemperature(response.jsonPath().get(String.format("data[%s].max_temp",i)));
            }

            weatherInformationObjects.add(weatherInformation);
        }
    }

}
