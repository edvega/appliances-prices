package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver;
	static String pathToDriver = Paths.get("").toAbsolutePath().toString() + 
			File.separator + "driverExecutables" + File.separator;

	@Parameters({"browser", "driverName"})
	@BeforeClass
	public void setupDriver(String browser, String driverFileName) {
		
		String osName = (System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows");
		if (browser.equals("chrome")) {
			if (osName.equals("windows")) {
				System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
			} else {
				System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
			}
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			// Add config
		}

		else if (browser.equals("iexplorer")) {
			// Add config
		}

		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public void takeScreenshot(String testName) {
		File img = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(img, new File("utilities/" + testName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
