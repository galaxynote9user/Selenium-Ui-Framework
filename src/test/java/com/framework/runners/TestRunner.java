package com.framework.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // path to the feature files
    glue = {"com.framework.stepdefinitions"}, // path to the step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
    monochrome = true, // for readable console output
    tags = "@Login" // optional: use this to specify which tests to run
)
public class TestRunner {
}
