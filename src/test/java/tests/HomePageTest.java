package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageTest extends BaseTest{
	@Test
	public void controlHomePage() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage
				.controlMainPage();
		System.out.println("Home Page Test Başarılı");
		Thread.sleep(5000);

	}
}
