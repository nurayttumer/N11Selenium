package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

    public void controlMainPage() {
		Assert.assertTrue(driver.getTitle().equals("n11.com - Alışverişin Uğurlu Adresi"));	
	}

}
