package com.framework.stepdefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.framework.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


public class ProductSteps{

    ProductPage productPage;
    public static String productprice, productname, productdesc;
    private static final Logger logger = LogManager.getLogger(ProductSteps.class);

    @When("Successfully Login to the Application and navigated to the product pages")
    public void sucesssfilly_login_to_the_application_and_navigated_to_the_product_pages() {
        productPage = new ProductPage(Hooks.driver);
    }
    
    @And("Select a product {string}")
    public void select_a_product(String string) {
        productPage.selectTheProduct(string);
    }
    
    @And("I click on the add to cart button")
    public void i_click_on_the_add_to_cart_button() {
        productPage.addtoCartClick();
    }
    
    @And("I Navigated to the Cart page")
    public void i_navigated_to_the_cart_page() {
        productPage.clickOnCartContainer();
    }
    
    @Then("I should able to see added product in the cart with expected details")
    public void i_should_able_to_see_added_product_in_the_cart_with_expected_details() {
        String productprice = productPage.getPrice();
        System.out.println(productprice);
    }

    @When("I click on filter option")
    public void i_click_on_filer_option()
    {
        productPage.checkfilterOption();
    }

    @Then("I should able to able to click on ascending name sort")
    public void i_click_on_asc_sort()
    {
        productPage.sortByNameAtoZ();
        //productPage.sortByNameZtoA();
    }

    @And("I verify the product names are sorted in ascending order")
    public void i_verify_product_names_in_asc_order()
    {
        boolean isSorted = productPage.areProductsSortedByName();
        Assert.assertTrue("Products are not sorted by Name A to Z", isSorted);
        System.out.println("Products are sorted in ascending order");
        logger.info("Products are sorted in ascending order");
    }

    @And("I should able to click on descending name sort")
    public void i_click_on_desc_sort()
    {
        productPage.sortByNameZtoA();
    }

    @Then("I verify the product names are sorted in descending order")
    public void i_verify_product_names_in_desc_order()
    {
        boolean isSorted = productPage.areProductsSortedByNameDesc();
        Assert.assertTrue("Products are not sorted by Name Z to A", isSorted);
        logger.info("Products are sorted in descending order");
    }



    @Then("I capture the product details")
    public void iCaptureTheProductDetails()
    {
        productprice = productPage.getProductPrice();
        productname = productPage.getProductName();
        productdesc = productPage.getProductDesc();
        logger.info("Product details captured");
    }

    @And("I click on checkout button")
    public void iClickOnCheckoutButton() {
        productPage.clickonCheckOut();
        logger.info("Clicked on checkout button");
    }

    @And("I enter the details {string} {string} {string}")
    public void iEnterTheDetails(String firstname, String lastname, String zipcode)
    {
         productPage.enterDetails(firstname, lastname, zipcode);
         logger.info("Entered basic details");
    }

    @And("I click on continue button")
    public void iClickOnContinueButton()
    {
        productPage.clickonContinue();
    }

    @And("I verify the product details in the checkout page")
    public void iVerifyTheProductDetailsInTheCheckoutPage()
    {
        String productprice_checkout = productPage.getProductPrice();
        String productname_checkout = productPage.getProductName();
        String productdesc_checkout = productPage.getProductDesc();
        Assert.assertEquals(productprice, productprice_checkout);
        Assert.assertEquals(productname, productname_checkout);
        Assert.assertEquals(productdesc, productdesc_checkout);
        logger.info("Product details verified in checkout page");
    }

    @And("I click on finish button")
    public void iClickOnFinishButton()
    {
        productPage.clickOnFinishButton();
    }

    @Then("I should able to see the order confirmation page")
    public void iShouldAbleToSeeTheOrderConfirmationPage()
    {
        productPage.checkProductPlacedMessage();
        logger.info("Order confirmation page displayed");
    }

    @Given("I click on Twitter link")
    public void iClickOnTwitterLink()
    {
        productPage.clickOnTwitterLink();
    }

    @Then("I should able to see the Twitter page")
    public void iShouldAbleToSeeTheTwitterPage() throws InterruptedException {
        productPage.checkTwitterPage();
    }

    @Given("I click on Facebook link")
    public void iClickOnFacebookLink()
    {
        productPage.clickOnFacebookLink();
    }

    @Then("I should able to see the Facebook page")
    public void iShouldAbleToSeeTheFacebookPage() throws InterruptedException {
        productPage.checkFacebookPage();
    }

    @Given("I click on Linkedin link")
    public void iClickOnLinkedinLink()
    {
        productPage.clickOnLinkedinLink();
    }

    @Then("I should able to see the Linkedin page")
    public void iShouldAbleToSeeTheLinkedinPage() throws InterruptedException {
        productPage.checkLinkedinPage();
    }
}
