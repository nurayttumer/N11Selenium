package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	 public WebDriver driver;
	@BeforeClass
	public void setup () throws InterruptedException {
		Thread.sleep(3000);
		//Create a Chrome driver. All test classes use this.
		driver = new ChromeDriver();
		driver.get("https://www.n11.com/");
		//Maximize Window
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown () {
		driver.quit();
	}
	}