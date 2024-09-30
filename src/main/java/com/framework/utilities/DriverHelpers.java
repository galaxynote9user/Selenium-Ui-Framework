package com.framework.utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    
    public void selectProduct(List<WebElement> productName,String productname) {
    	for(WebElement product:productName) {
    		if(product.equals(productname)) {
    			product.click();
    			break;
    		}
    	}
    }
}
