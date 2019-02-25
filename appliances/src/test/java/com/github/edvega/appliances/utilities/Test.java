package com.github.edvega.appliances.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	private static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	private static By departments = By.xpath("//ul[@id='menu']/li");
	private static By appliances = By.xpath("//ul[@id='menu']/li/ul/li[12]");
	private static By fridges = By.xpath("//*[contains(text(),'Refrigeradores y Congeladores')]");
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/home/edwin/repositories/automation-test/appliances/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.liverpool.com.mx");
		action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("//ul[@id='menu']/li"))).perform();
		
		hover(departments);
		hover(appliances);
		hoverAndClick(fridges);
	}
	
	public static void hover(By elementBy) {
		waitVisibility(elementBy);
		action.moveToElement(driver.findElement(elementBy)).perform();
	}
	
	public static void hoverAndClick(By elementBy) {
		waitVisibility(elementBy);
		action.moveToElement(driver.findElement(elementBy)).click().perform();
	}
	
	public static void waitVisibility(By elementBy) {
		new WebDriverWait(driver, 15).until(
				ExpectedConditions.visibilityOfElementLocated(elementBy));
	}
}