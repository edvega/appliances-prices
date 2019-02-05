package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.BasePage;

public class HomePage extends BasePage {

	private String baseUrl = "http://www.amazon.com";
	private By searchBox = By.id("twotabsearchtextbox");
	private By shoppingCart = By.id("nav-cart");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage goToHomePage() {
		driver.get(baseUrl);
		return this;
	}
	
	public HomePage searchProduct(String text) {
		writeText(searchBox, text);
		return this;
	}
	
	public HomePage goToMyCart() {
		click(shoppingCart);
		return this;
	}
}
