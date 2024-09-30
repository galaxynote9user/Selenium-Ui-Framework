package com.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.framework.utils.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static final String CONFIG_FILE_PATH = "src/main/resources/config/config.properties";
    private static final PropertiesUtil propertiesUtil = new PropertiesUtil(CONFIG_FILE_PATH);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = propertiesUtil.getProperty("browser", "chrome").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "safari":
                    driver.set(new SafariDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.get().manage().window().maximize(); // Maximize the browser window
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}