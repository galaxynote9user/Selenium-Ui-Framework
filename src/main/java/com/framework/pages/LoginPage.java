package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePage{
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    public LoginPage(WebDriver driver) {
    	super(driver);
    }

    @FindBy(id ="user-name" )
    private WebElement username;
    @FindBy(id ="password" )
    private WebElement password;

    @FindBy(id ="login-button" )
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMessage;

    public void enterUsername(String user) {
        username.sendKeys(user);
        logger.info("Entering User Name : "+user);
    }

    public void enterPassword(String pass) {
       password.sendKeys(pass);
       logger.info("Entering User Password : "+pass);
    }

    public void clickLogin() {
        loginButton.click();
        logger.info("Clicked on Login Button");
    }

    public void verifyErrorMessage() {
        errorMessage.isDisplayed();

        if(errorMessage.isDisplayed())
        {
            logger.info("Error Message is displayed");
        }
        else
        {
            logger.info("Error Message is not displayed");
        }
    }
}
