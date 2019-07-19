package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	public void click(By elementBy) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).click();
	}

	public WebElement clearAndSendKeys(By by, String value) {
        WebElement element = getElementBy(by);
        element.clear();
        element.sendKeys(value);
        return element;
    }

	private WebElement getElementBy(By by) {
		return waitForElement(driver,30,by);
	}

	
	public WebElement waitForElement(WebDriver driver, int seconds, By elementBy) {
        return (new WebDriverWait(driver, seconds))
                .until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }
	
	public String readText(By elementBy) {
		waitVisibility(elementBy);
		return driver.findElement(elementBy).getText();
	}

	public void hitEnter() throws AWTException {
		//native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void zoomIn(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '1.50'");
	}

	public void set100(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '1.00'");
	}

	public void zoomOut(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '0.67'");
	}

	public static WebElement waitForElementClickableByWebElement(WebDriver driver,
																 final WebElement elm, int timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(elm));
			driver.manage().timeouts()
					.implicitlyWait(5, TimeUnit.SECONDS); // reset
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    public String getTextBy(By by){
        return getElementBy(by).getText();
    }
}
