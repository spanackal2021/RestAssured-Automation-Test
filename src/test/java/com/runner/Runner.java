package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/features",
        glue = { "com.steps" },
        plugin = { "pretty", "html:test-output/cucumber-reports/cucumber-pretty","json:test-output/cucumber-reports/CucumberTestReport.json"},
        monochrome = true)

public class Runner {

}

