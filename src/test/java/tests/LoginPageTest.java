package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginPageTest extends BaseTest {
	@Test
	public void controlLoginPage() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage
				.loginToN11("zeynepturnali23@gmail.com","507zeynep")
				.verifyLoginUserInfos();
		System.out.println("Login Test Başarılı");
	}

}
