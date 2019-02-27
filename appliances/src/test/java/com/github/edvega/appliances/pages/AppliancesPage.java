package com.github.edvega.appliances.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.edvega.appliances.utilities.BasePage;

public class AppliancesPage extends BasePage {

	private By filterHeader = By.xpath("//div[@class='fac-wrapper']/h2");
	private By productsCounter = By.xpath("//div[@id='product-total']/p/span");
	private By filterBlock = By.id("filterBlock");
	private By orderBy = By.xpath("//div[@id='controls-top']/div[4]/div/label/select");
	private By productList = By.cssSelector(".price-state.price-special");
	
	public AppliancesPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFilterHeader() {
		return readText(filterHeader);
	}
	
	public String getProductsCounter() {
		return readText(productsCounter);
	}
	
	public AppliancesPage isFiltersPresent() {
		waitVisibility(filterBlock);
		return this;
	}
	
	public AppliancesPage setOrderBySelection(String visibleText) {
		Select sort = new Select(driver.findElement(orderBy));
		sort.selectByVisibleText(visibleText);
		return this;
	}
	
	public String getOrderBySelection() {
		Select sort = new Select(driver.findElement(orderBy));
		return sort.getFirstSelectedOption().getText();
	}
	
	public ArrayList<WebElement> getProductsList() {
		waitVisibility(productList);
		return new ArrayList<WebElement>(driver.findElements(productList));
	}
}