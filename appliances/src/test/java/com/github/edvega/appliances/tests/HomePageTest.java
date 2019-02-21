package com.github.edvega.appliances.tests;

import org.testng.annotations.Test;

import com.github.edvega.appliances.pages.HomePage;
import com.github.edvega.appliances.utilities.BaseTest;

public class HomePageTest extends BaseTest {

	@Test(priority = 0)
	public void verifyHomePage() {
		HomePage home = new HomePage(driver);
		home.goToHomePage();
	}
	
	@Test(priority = 2)
	public void clickCart() {
		HomePage home = new HomePage(driver);
		home.goToHomePage().goToShoppingCart();
	}
	
	@Test(priority = 1)
	public void verifySearchBox() {
		HomePage home = new HomePage(driver);
		home.goToHomePage().searchItem("ray ban wayfarer");
	}
	
	@Test(priority = 3)
	public void seeAppliancesSection() {
		HomePage home = new HomePage(driver);
		home.goToHomePage().goToAppliances();
	}
	
	@Test(priority = 4, groups = {"login"})
	public void openLoginForm() {
		HomePage home = new HomePage(driver);
		home.goToHomePage().goToLogin("useruser", "1234");
	}
}