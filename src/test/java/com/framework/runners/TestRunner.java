package com.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.framework.drivers.DriverManager;

@CucumberOptions(
    features = "src/test/resources/features", // path to the feature files
    glue = {"com.framework.stepdefinitions"}, // path to the step definitions
    plugin = {"pretty","html:target/cucumber-reports.html",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    tags = "@Login" // optional: use this to specify which tests to run
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        DriverManager.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        DriverManager.quitDriver();
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}