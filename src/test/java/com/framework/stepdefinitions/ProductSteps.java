package com.framework.stepdefinitions;

import com.framework.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ProductSteps{
    ProductPage productPage;
    
    @When("Sucesssfilly Login to the Application and navigated to the product pages")
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
        System.out.println("Products are sorted in descending order");
    }
}
