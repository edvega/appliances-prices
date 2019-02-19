package com.github.edvega.appliances.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	
	public BasePage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		action = new Actions(driver);
	}
	
	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
	}
	
	public void hover(By elementBy) {
		waitVisibility(elementBy);
		action.moveToElement(driver.findElement(elementBy)).perform();
	}
	
	public void hoverAndClick(By elementBy) {
		waitVisibility(elementBy);
		action.moveToElement(driver.findElement(elementBy)).click().perform();
	}
	
	public void click(By elementBy) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).click();
	}
	
	public void writeText(By elementBy, String text) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
	}
	
	public void writeTextAndEnter(By elementBy, String text) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
		driver.findElement(elementBy).sendKeys(Keys.ENTER);
	}
	
	public String readText(By elementBy) {
		waitVisibility(elementBy);
		return driver.findElement(elementBy).getText();
	}
	
	public String readPageTitle() {
		return driver.getTitle();
	}
	
	public void assertEquals(By elementBy, String expectedText) {
		waitVisibility(elementBy);
		Assert.assertEquals(readText(elementBy), expectedText);
	}
}