package com.framework.stepdefinitions;

import com.framework.pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginSteps {
    LoginPage loginPage;
    

    @Given("I open the browser and navigate to Saucelabs login page")
    public void iOpenTheBrowserAndNavigateToSaucelabsLoginPage() {
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(Hooks.driver);
    }

    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }
}
