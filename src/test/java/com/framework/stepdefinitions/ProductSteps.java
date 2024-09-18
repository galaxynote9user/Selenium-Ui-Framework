package com.framework.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.framework.pages.LoginPage;
import com.framework.pages.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ProductSteps {
	WebDriver driver;
    ProductPage productPage;
	
	@Given("Sucesssfilly Login to the Application")
	public void sucesssfilly_login_to_the_application() {
		productPage=new ProductPage(driver);
	}
	@When("Select a product {string}")
	public void select_a_product(String string) {
		productPage.selectTheProduct(string);;
	}
	@When("Validating price of the product and Add to cart button")
	public void validating_price_of_the_product_and_add_to_cart_button() {
		String price =productPage.getPrice();
		System.out.println(price);
		productPage.addtoCartLick();
	}


}
