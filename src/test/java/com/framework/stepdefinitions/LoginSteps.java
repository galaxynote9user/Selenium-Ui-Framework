package com.framework.stepdefinitions;

import java.io.IOException;

import com.framework.utils.PropertiesReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.framework.pages.LoginPage;
import com.framework.utils.ExcelReader;

import io.cucumber.java.en.*;

public class LoginSteps {
    LoginPage loginPage;

    String configfilePath = "src/main/resources/config/config.properties";
    String testdatafilePath = "src/main/resources/testdata/testdata.properties";

    PropertiesReader configReader = new PropertiesReader(configfilePath);
    PropertiesReader testdataReader = new PropertiesReader(testdatafilePath);

    String url = configReader.getProperty("url");
    String username_prop = testdataReader.getProperty("username");
    String password_prop = testdataReader.getProperty("password");

    @Given("I open the browser and navigate to Saucelabs login page")
    public void iOpenTheBrowserAndNavigateToSaucelabsLoginPage() {
        Hooks.driver.get(url);
        loginPage = new LoginPage(Hooks.driver);
    }

    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username_prop);
        loginPage.enterPassword(password_prop);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }
    
    @When("I enter valid username {string} and invalid password {string}")
    public void i_enter_valid_username_and_invalidpassword(String string1, String string2) throws IOException {{
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
}