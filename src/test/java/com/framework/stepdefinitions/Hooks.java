package com.framework.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.framework.utilities.DriverHelpers;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp()
    {
        driver = DriverHelpers.startDriver();
    }

    @After
    public void tearDown()
    {
        if(driver!=null)
        {
            DriverHelpers.closeDriver();
        }
    }
}
