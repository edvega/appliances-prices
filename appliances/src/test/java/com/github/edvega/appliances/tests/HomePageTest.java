package com.github.edvega.appliances.tests;

import org.testng.annotations.Test;

import com.github.edvega.appliances.pages.HomePage;
import com.github.edvega.appliances.utilities.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void verifyHomePage() {
		HomePage home = new HomePage(driver);
		home.goToHomePage();
	}
}