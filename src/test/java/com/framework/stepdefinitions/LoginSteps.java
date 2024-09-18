package com.framework.stepdefinitions;

import com.framework.pages.LoginPage;
import com.framework.utilities.DriverHelpers;
import io.cucumber.java.en.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I open the browser and navigate to Saucelabs login page")
    public void iOpenTheBrowserAndNavigateToSaucelabsLoginPage() {
        driver = DriverHelpers.startDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
        Actions s=new Actions(driver);
        s.sendKeys(Keys.ENTER);
    }
}
