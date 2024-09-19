package com.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.utilities.DriverHelpers;

import junit.framework.Assert;

public class ProductPage extends BasePage {
WebDriver driver;
public ProductPage(WebDriver driver) {
	super(driver);
	//this.driver=driver;
}


 private By productName= By.xpath("//div[@class='inventory_item_name ']");
 @FindBy(xpath="//div[@class='inventory_item_price']")
 private WebElement tshirtprice;
 @FindBy(xpath="(//div[text()='Sauce Labs Bolt T-Shirt']//following::button[text()='Add to cart'])[1]") 
private WebElement addtocart;		 
 

 @FindBy(xpath="//span[text()='Products']") 
 private WebElement productHeader;
 @FindBy(css = "div#shopping_cart_container")
 private WebElement clickOnCartContainer;

 DriverHelpers drihel=new DriverHelpers();
 
 public void selectTheProduct(String productname) {
	 System.out.println(productname);
//	 String ActualProdName=productHeader.getText();
//	 System.out.println(ActualProdName);
	// Assert.assertEquals(ActualProdName, productname);
	
	  }

public String getPrice() {
	return tshirtprice.getText();
}
public void addtoCartLick() {
	addtocart.click();
}

	public void clikeOnCartContainer() {
		clickOnCartContainer.click();
	}
	
}
