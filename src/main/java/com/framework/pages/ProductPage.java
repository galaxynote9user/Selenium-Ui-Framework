package com.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.utilities.DriverHelpers;

public class ProductPage {
WebDriver driver;
public ProductPage(WebDriver driver) {
	this.driver=DriverHelpers.startDriver();
}
 By productName= By.xpath("//div[@class='inventory_item_name ']");
 By Price=By.xpath("(//div[text()='Sauce Labs Bolt T-Shirt']//following::div[@class='inventory_item_price'])[1]");
 By addtoCart=By.xpath("(//div[text()='Sauce Labs Bolt T-Shirt']//following::button[text()='Add to cart'])[1]");
 
 
 DriverHelpers drihel=new DriverHelpers();
 
 public void selectTheProduct(String productname) {
	// drihel.selectProduct( productName, productname);
	 System.out.println(productname);
	  }

public String getPrice() {
	return driver.findElement(Price).getText();
}
public void addtoCartLick() {
	driver.findElement(addtoCart).click();
}

	
	
}
