package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    WebDriver driver;

    public LoginPage(WebDriver driver) {
    	super(driver);
    }

    @FindBy(id ="user-name" )
    private WebElement username;
    @FindBy(id ="password" )
    private WebElement password;

    @FindBy(id ="login-button" )
    private WebElement loginButton;

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
       password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
