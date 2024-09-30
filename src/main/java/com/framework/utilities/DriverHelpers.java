package com.framework.utilities;

import org.openqa.selenium.WebDriver;

import com.framework.drivers.DriverManager;

public class DriverHelpers {
    public static WebDriver startDriver() {
        WebDriver driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        DriverManager.quitDriver();
    }
    
}
