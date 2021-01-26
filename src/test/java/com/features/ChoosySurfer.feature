Feature: Surfer is able to surf only on days with good weather

Scenario: As a choosy surfer
Given I aim to surf in a beach in Sydney having country code as "AU"
And I only like to surf on any two days specifically "Thursday" and "Friday" in next 16 Days
When I look up the the weather forecast for the next 16 days using POSTAL CODE "2077"
Then I check to if see the temperature is between "15°C" and "30°C" and UV index is <= 5
And I Pick two spots based on suitable weather forecast for the day
