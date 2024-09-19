package com.framework.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.framework.pages.LoginPage;
import com.framework.pages.ProductPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
	 WebDriver driver;
     ProductPage productPage;
    public  String ProductName="Products";
	
//	@Given("Sucesssfilly Login to the Application")
//	public void sucesssfilly_login_to_the_application() {
//		productPage=new ProductPage(driver);
//	}
//	@When("Select a product {string}")
//	public void select_a_product(String string) {
//		productPage.selectTheProduct(string);;
//	}
//	@When("Validating price of the product and Add to cart button")
//	public void validating_price_of_the_product_and_add_to_cart_button() {
//		String price =productPage.getPrice();
//		System.out.println(price);
//		productPage.addtoCartLick();
//	}
	
	
	
	//////
	
	@When("Sucesssfilly Login to the Application and navigated to the product pages")
	public void sucesssfilly_login_to_the_application_and_navigated_to_the_product_pages() {
		
	   productPage=new ProductPage(driver);
	 //  productPage.selectTheProduct(ProductName);
	}
	@And("Select a product {string}")
	public void select_a_product(String string) {
		productPage.selectTheProduct(string);;
	}
	
	@And("I click on the add to cart button")
	public void i_click_on_the_add_to_cart_button() {
	   productPage.addtoCartLick();
	}
	@And("I Navigated to the Cart page")
	public void i_navigated_to_the_cart_page() {
		productPage.clikeOnCartContainer();
	}
	@Then("I should able to see added product in the cart with expected details")
	public void i_should_able_to_see_added_product_in_the_cart_with_expected_details() {
	  String productprice=productPage.getPrice();
	  System.out.println(productprice);
	}


}
