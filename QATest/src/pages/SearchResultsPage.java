package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BasePage;

public class SearchResultsPage extends BasePage {

	private By plastic = By.xpath("//*[@id='leftNavContainer']/ul[2]/div/li[1]/span/span/div/label/span/span");
	private By searchByMinPriceBox = By.id("low-price");
	private By searchByHighPriceBox = By.id("high-price");
	private By searchPriceRangeGoButton = By.xpath("//input[@value='Go'][1]");
	private By resultItemsList = By.xpath("//ul[@id='s-results-list-atf']/li");
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public SearchResultsPage selectPlasticMaterial() {
		click(plastic);
		return this;
	}
	
	public SearchResultsPage searchByPriceRange(String minPrice, String maxPrice) {
		writeText(searchByMinPriceBox, minPrice);
		writeText(searchByHighPriceBox, maxPrice);
		click(searchPriceRangeGoButton);
		return this;
	}
	
	public ArrayList<WebElement> getResultsItems() {
		waitVisibility(resultItemsList);
		return new ArrayList<WebElement>(driver.findElements(resultItemsList));
	}
}
