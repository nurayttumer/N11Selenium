package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By usernameBy = By.id("email");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("loginButton");
    By loginTextBy = By.partialLinkText("Giriş Yap");
    
  
    public LoginPage loginToN11 (String username, String password){
    	click(loginTextBy);
        //Enter Username(Email)
    	clearAndSendKeys(usernameBy,username);
        //Enter Password
    	clearAndSendKeys(passwordBy, password);
        //Click Login Button
        click(loginButtonBy);
        return this;
    }
 
    //Verify Username Condition
    public LoginPage verifyLoginUserInfos () {
        Assert.assertTrue(getTextBy(By.cssSelector(".user")).equals("Zeynep Turnalı"));
        return this;
    }
 
    
}
