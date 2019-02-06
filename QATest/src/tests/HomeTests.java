package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import utilities.BaseTest;

public class HomeTests extends BaseTest {

	@Test
	public void verifyHomePage() {
		HomePage home = new HomePage(driver);
		home.goToHomePage();
	}
	
	@Test
	public void verifyHomeTitle() {
		HomePage home = new HomePage(driver);
		home.goToHomePage();
		String title = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		assertEquals(home.readPageTitle(), title);
	}
	
	@Test
	public void verifySearchBox() {
		HomePage home = new HomePage(driver);
		home.goToHomePage();
		home.searchProduct("ipad air 2 case");
	}
}
