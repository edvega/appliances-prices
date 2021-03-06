package com.github.edvega.appliances.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	static String pathToDriver = Paths.get("").toAbsolutePath().toString() + 
			File.separator + "drivers" + File.separator;
	
	@BeforeTest(alwaysRun = true)
	@Parameters({"browser", "driverName"})
	public void setupDriver(String browser, String driverFileName) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", pathToDriver + driverFileName);
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		
		if (driver != null) {
			driver.quit();
		}
	}
	
	public void takeScreenshot(String testName) {
		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(img, new File("ss/" + testName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}