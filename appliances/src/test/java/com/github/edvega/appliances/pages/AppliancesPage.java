package com.github.edvega.appliances.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.edvega.appliances.utilities.BasePage;

public class AppliancesPage extends BasePage {

	private By filterHeader = By.xpath("//div[@class='fac-wrapper']/h2");
	private By productsCounter = By.xpath("//div[@id='product-total']/p/span");
	private By filterBlock = By.id("filterBlock");
	private By orderBy = By.xpath("//div[@id='controls-top']/div[4]/div/label/select");
	
	public AppliancesPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFilterHeader() {
		return readText(filterHeader);
	}
	
	public AppliancesPage getProductsCounter() {
		readText(productsCounter);
		return this;
	}
	
	public AppliancesPage isFiltersPresent() {
		waitVisibility(filterBlock);
		return this;
	}
	
	public String getOrderBySelection() {
		Select sort = new Select(driver.findElement(orderBy));
		return sort.getFirstSelectedOption().getText();
	}
}