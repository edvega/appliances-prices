package com.github.edvega.appliances.tests;

import org.testng.annotations.Test;

import com.github.edvega.appliances.pages.HomePage;
import com.github.edvega.appliances.utilities.BaseTest;

public class AppliancesPageTest extends BaseTest {

	@Test
	public void verifyFilterHeader() {
		HomePage home = new HomePage(driver);
		home.goToHomePage().goToAppliances();
		//System.out.println(ome.goToAppliances().getFilterHeader());
	}
	
}