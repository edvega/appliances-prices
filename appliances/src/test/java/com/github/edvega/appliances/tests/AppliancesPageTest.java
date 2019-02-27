package com.github.edvega.appliances.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.github.edvega.appliances.pages.HomePage;
import com.github.edvega.appliances.utilities.BaseTest;

public class AppliancesPageTest extends BaseTest {

	@Test
	public void verifyFilterHeader() {
		HomePage home = new HomePage(driver);
		String title = home.goToHomePage().goToAppliances().getFilterHeader();
		assertEquals(title, "LÍNEA BLANCA");
	}
	
	@Test
	public void productsCounter() {
		HomePage home = new HomePage(driver);
		System.out.println(home.goToHomePage().goToAppliances().
				getProductsCounter());
	}
	
	@Test
	public void setOrderOfResults() {
		HomePage home = new HomePage(driver);
		home.goToHomePage().goToAppliances().setOrderBySelection("Más Vendido");
	}
	
	@Test(groups = {"results"})
	public void getFirstFivePrices() {
		HomePage home = new HomePage(driver);
		ArrayList<WebElement> list = home.goToHomePage().goToAppliances()
				.getProductsList();
		
		for (WebElement e : list) {
			System.out.println(e.findElement(By
					.xpath("//span[@class='price-amount']")).getText());
		}
	}
}