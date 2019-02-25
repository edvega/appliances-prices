package com.github.edvega.appliances.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.edvega.appliances.utilities.BasePage;

public class HomePage extends BasePage {
	
	private String baseUrl = "https://www.liverpool.com.mx";
	private By searchBox = By.id("buscador");
	private By departments = By.xpath("//ul[@id='menu']/li");
	private By appliances = By.xpath("//ul[@id='menu']/li/ul/li[12]");
	private By fridges = By.xpath("//*[contains(text(),'Refrigeradores y Congeladores')]");
	private By cart = By.id("bag");
	private By loginButton = By.id("login_btn");
	private By user = By.id("login");
	private By pass = By.id("pass");
	
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
	
	public AppliancesPage goToAppliances() {
		hover(departments);
		hover(appliances);
		hoverAndClick(fridges);
		return new AppliancesPage(driver);
	}
	
	public HomePage searchItem(String item) {
		click(searchBox);
		writeTextAndEnter(searchBox, item);
		return this;
	}
	
	public HomePage goToLogin(String user, String pass) {
		click(loginButton);
		waitVisibility(By.className("fancybox-iframe"));
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
		writeText(this.user, user);
		writeTextAndEnter(this.pass, pass);
		driver.switchTo().defaultContent();
		return this;
	}
}