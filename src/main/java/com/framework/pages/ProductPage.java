package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.utilities.DriverHelpers;
import java.util.stream.Collectors;
import io.cucumber.messages.types.Duration;
import junit.framework.Assert;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductPage extends BasePage {
  private static final Logger logger = LogManager.getLogger(ProductPage.class);
    public ProductPage(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath="//div/a[@id='item_1_title_link']")
	private WebElement productName;

    @FindBy(xpath="//div[@class='inventory_item_price']")
    private WebElement tshirtprice;
    
    @FindBy(xpath="(//div[text()='Sauce Labs Bolt T-Shirt']//following::button[text()='Add to cart'])") 
    private WebElement addtocart;         

    @FindBy(xpath="//span[text()='Products']") 
    private WebElement productHeader;
    
    @FindBy(css = "div#shopping_cart_container")
    private WebElement clickOnCartContainer;

    @FindBy(css = ".product_sort_container")
    private WebElement sortDropdown;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(xpath="//button[@id='checkout']")
    private WebElement checkout;


    public void selectTheProduct(String productname) {
        waitForElementToBeVisible(productHeader);
        
        System.out.println(productname);
        String ActualProdName = productName.getText();
        System.out.println(ActualProdName);
        Assert.assertEquals(ActualProdName.toLowerCase(), productname.toLowerCase());
        logger.info("Product Actual name and fetched names are same");
    }

    public String getPrice() {
        waitForElementToBeVisible(tshirtprice);
        return tshirtprice.getText();
    }

    public void addtoCartClick() {
        waitForElementToBeVisible(addtocart);
        addtocart.click();
        logger.info("Added Product to cart");
    }

    public void clickOnCartContainer() {
        waitForElementToBeClickable(clickOnCartContainer);
        clickOnCartContainer.click();
    }

    public void checkfilterOption()
    {
        waitForElementToBeClickable(sortDropdown);
        System.out.println("Filter Option is present");
        logger.info("Filter Option is present");
    }

    public void sortByNameAtoZ() {
        waitForElementToBeClickable(sortDropdown);
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText("Name (A to Z)");
    }

    public void sortByNameZtoA() {
        waitForElementToBeClickable(sortDropdown);
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByVisibleText("Name (Z to A)");
    }

    public boolean areProductsSortedByName() {
        List<String> names = productNames.stream()
                                         .map(WebElement::getText)
                                         .collect(Collectors.toList());
        List<String> sortedNames = names.stream()
                                        .sorted()
                                        .collect(Collectors.toList());
        return names.equals(sortedNames);
    }

    public boolean areProductsSortedByNameDesc() {
        List<String> names = productNames.stream()
                                         .map(WebElement::getText)
                                         .collect(Collectors.toList());
        List<String> sortedNames = names.stream()
                                        .sorted((a, b) -> b.compareTo(a))
                                        .collect(Collectors.toList());
        return names.equals(sortedNames);
    }

    public void clickonCheckOut() {
        checkout.click();
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    public void enterDetails(String firstname, String lastname, String postalcode) {
        waitForElementToBeVisible(firstName);
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        postalCode.sendKeys(postalcode);
    }


    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    public void clickonContinue() {
        continueButton.click();
    }

    @FindBy(xpath = "//div[@data-test='inventory-item-desc']")
    private WebElement productPageDesc;

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private WebElement productPageName;

    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    private WebElement productPagePrice;

    public String getProductPrice() {
        return productPagePrice.getText();
    }

    public String getProductName() {
        return productPageName.getText();
    }

    public String getProductDesc() {
        return productPageDesc.getText();
    }

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    public void clickOnFinishButton() {
        finishButton.click();
    }

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;

    public void checkProductPlacedMessage() {
        waitForElementToBeVisible(completeHeader);
        String actualMessage = completeHeader.getText();
        Assert.assertEquals("Thank you for your order!", actualMessage);

    }

}
