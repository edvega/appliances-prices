package com.github.edvega.appliances.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.edvega.appliances.utilities.BasePage;

public class HomePage extends BasePage {
	
	private String baseUrl = "https://www.liverpool.com.mx";
	private By searchBox = By.id("buscador");
	private By departments = By.xpath("//ul[@id='menu']/li");
	private By appliances = By.xpath("//ul[@id='menu']/li/ul/li[12]");
	private By fridges = By.xpath("//*[contains(text(),'Refrigeradores y Congeladores')]");
	private By cart = By.id("bag");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage goToHomePage() {
		driver.get(baseUrl);
		return this;
	}
	
	public HomePage goToShoppingCart() {
		click(cart);
		return this;
	}
	
	public HomePage goToAppliances() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(departments))
			.moveToElement(driver.findElement(appliances))
			.moveToElement(driver.findElement(fridges))
			.click().perform();
		return this;
	}
	
	public HomePage searchItem(String item) {
		click(searchBox);
		writeTextAndEnter(searchBox, item);
		return this;
	}
}