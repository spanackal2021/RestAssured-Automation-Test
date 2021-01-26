$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ChoosySurfer.feature");
formatter.feature({
  "line": 1,
  "name": "Surfer is able to surf only on days with good weather",
  "description": "",
  "id": "surfer-is-able-to-surf-only-on-days-with-good-weather",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "As a choosy surfer",
  "description": "",
  "id": "surfer-is-able-to-surf-only-on-days-with-good-weather;as-a-choosy-surfer",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I aim to surf in a beach in Sydney having country code as \"AU\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I only like to surf on any two days specifically \"Thursday\" and \"Friday\" in next 16 Days",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I look up the the weather forecast for the next 16 days using POSTAL CODE \"2077\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I check to if see the temperature is between \"15°C\" and \"30°C\" and UV index is \u003c\u003d 5",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I Pick two spots based on suitable weather forecast for the day",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "AU",
      "offset": 59
    }
  ],
  "location": "StepDefinition.iAimToSurfInABeachInSydneyHavingCountryCodeAs(String)"
});
formatter.result({
  "duration": 240753819,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Thursday",
      "offset": 50
    },
    {
      "val": "Friday",
      "offset": 65
    },
    {
      "val": "16",
      "offset": 81
    }
  ],
  "location": "StepDefinition.iOnlyLikeToSurfOnAnyTwoDaysSpecificallyAndInNextDays(String,String,int)"
});
formatter.result({
  "duration": 795858,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "16",
      "offset": 48
    },
    {
      "val": "2077",
      "offset": 75
    }
  ],
  "location": "StepDefinition.iLookUpTheTheWeatherForecastForTheNextDaysUsingPOSTALCODE(int,String)"
});
formatter.result({
  "duration": 6506391575,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "15°C",
      "offset": 46
    },
    {
      "val": "30°C",
      "offset": 57
    },
    {
      "val": "5",
      "offset": 82
    }
  ],
  "location": "StepDefinition.iCheckToIfSeeTheTemperatureIsBetweenAndAndUVIndexIs(String,String,int)"
});
formatter.result({
  "duration": 10926472,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iPickTwoSpotsBasedOnSuitableWeatherForecastForTheDay()"
});
formatter.result({
  "duration": 2727607,
  "status": "passed"
});
});