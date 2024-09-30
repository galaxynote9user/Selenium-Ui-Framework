package com.framework.stepdefinitions;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;

import com.framework.pages.LoginPage;
import com.framework.utils.ExcelReader;
import com.framework.utils.PropertiesUtil;
import io.cucumber.java.en.*;
import com.framework.drivers.DriverManager;

public class LoginSteps {
    private LoginPage loginPage;
    private WebDriver driver;


    private static final String TESTDATA_FILE_PATH = "src/main/resources/testdata/testdata.properties";
    private static final String CONFIG_FILE_PATH = "src/main/resources/config/config.properties";
    private static final PropertiesUtil testdata = new PropertiesUtil(TESTDATA_FILE_PATH);
    private static final PropertiesUtil config = new PropertiesUtil(CONFIG_FILE_PATH);
    private String url, username, password;

    @Given("I open the browser and navigate to Saucelabs login page")
    public void iOpenTheBrowserAndNavigateToSaucelabsLoginPage() {
        url = config.getProperty("url");
        driver = DriverManager.getDriver();
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String data1, String data2) {
        username = testdata.getProperty("username");
        password = testdata.getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }
    
    @When("I enter valid username {string} and invalidpassword {string}")
    public void i_enter_valid_username_and_invalidpassword(String string, String string2) throws IOException 
    {
        {
    	    XSSFSheet sheet = ExcelReader.readExcelData("src/test/resources/testdata/testdata.xlsx", "Sheet1");
            int rowCount = sheet.getLastRowNum();

            for (int i = 1; i <= rowCount; i++) {
                String username = sheet.getRow(i).getCell(0).getStringCellValue();
                String password = sheet.getRow(i).getCell(1).getStringCellValue();

                loginPage.enterUsername(username);
                loginPage.enterPassword(password);
            }
        }
    }

    @And("I should see the error message")
    public void iShouldSeeTheErrorMessage() {
        loginPage.verifyErrorMessage();
    }
}