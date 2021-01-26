## Description:
Rest Assured Automation Suite for getting information from the weather API to determine which Thursday and Friday in the next 16 days are having good weather to surf

## Key Features:
1. End to End Rest Assured Tests for getting information from the weather API to determine which Thursday and Friday in the next 16 days are having good weather to surf
1. Simple Cucumber Report can be accessed under test-output/cucumber-reports/cucumber-pretty/index.html
1. Detailed Cucumber Report can be accessed under test-output/cucumber-reports/advanced-reports/overview-features.html
1. Assertions done to verify that the API response is a valid JSON.
1. Assertions done to verify that the API response provides information for the next 16 days.
1. Assertions done to verify that the final filtered API response meets the weather criteria for the next 16 days.
 
 
## Assumptions:
1. For demo purposes since the filtered response based on the weather criteria that was initially given in the test for most postcodes were empty, have made slight modifications/tweaks to the weather criteria that would provide results, as can be seen in the feature file parameters.
 
 
## Instruction:
1. To trigger the test first please clone the repository and  thereafter navigate to the project directory.
 Please type in the below command and hit Enter to launch the tests:
 
   mvn clean install
 
