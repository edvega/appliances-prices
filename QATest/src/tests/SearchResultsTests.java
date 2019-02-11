package tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.BaseTest;

public class SearchResultsTests extends BaseTest {

	@Test(priority = 0)
	public void selectPlasticCase() {
		HomePage home = new HomePage(driver);
		home.searchProduct("ipad air 2 case").selectPlasticMaterial();
	}

	@Test(priority = 1)
	public void verifyPriceRange() {
		HomePage home = new HomePage(driver);
		home.searchProduct("ipad air 2 case").selectPlasticMaterial()
			.searchByPriceRange("20", "100");
	}
	
	@Test(priority = 2)
	public void resultsBetweenPriceRange() {
		HomePage home = new HomePage(driver);
		ArrayList<WebElement> items = home.searchProduct("ipad air 2 case")
				.selectPlasticMaterial().searchByPriceRange("20", "100")
				.getResultsItems();
		System.out.println(items.size());
		for (int i = 0; i < 5; i++) {
			System.out.println(items.get(i)
					.findElements(By.tagName("div")).size());
		}
	}
}
