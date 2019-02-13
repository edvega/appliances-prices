package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BasePage;

public class SearchResultsPage extends BasePage {

	private By plastic = By.xpath("//*[contains(text(),'Plastic')]");
	private By searchByMinPriceBox = By.id("low-price");
	private By searchByHighPriceBox = By.id("high-price");
	private By resultItemsList = By.xpath("//div[@class='s-result-list sg-row']/div/div/div/div");
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public SearchResultsPage selectPlasticMaterial() {
		click(plastic);
		return this;
	}
	
	public SearchResultsPage searchByPriceRange(String minPrice, String maxPrice) {
		writeText(searchByMinPriceBox, minPrice);
		writeTextAndEnter(searchByHighPriceBox, maxPrice);
		return this;
	}
	
	public ArrayList<WebElement> getResultsItems() {
		waitVisibility(resultItemsList);
		return new ArrayList<WebElement>(driver.findElements(resultItemsList));
	}
}
