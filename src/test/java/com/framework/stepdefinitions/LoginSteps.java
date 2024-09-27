package com.framework.stepdefinitions;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.framework.pages.LoginPage;
import com.framework.utils.ExcelReader;

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
    
    @When("I enter valid username {string} and invalidpassword {string}")
    public void i_enter_valid_username_and_invalidpassword(String string, String string2) throws IOException {{
    	XSSFSheet sheet = ExcelReader.readExcelData("./src/test/resources/testdata/testdata.xlsxtestdata.xlsx", "Sheet1");
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