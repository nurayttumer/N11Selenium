package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;

public class SearchAndResultPage extends BasePage{

	public SearchAndResultPage(WebDriver driver) {
		super(driver);
	}

	By getSearchBox = By.cssSelector("#searchData");
	By activeSecondPage = By.xpath("//a[contains(@class,'next navigation')]");
	By activePage = By.xpath("//a[contains(@class,'active ')]");
    By product = By.xpath("(//h3[contains(@class,'productName bold')])[6]");
    By addToBasket = By.partialLinkText("Sepete Ekle");
    By productPrice = By.cssSelector(".priceDetail ins") ;
	By basketPrice = By.cssSelector(".price:nth-child(2)");
	By goToBasket = By.cssSelector(".btnGoBasket");
	By increaseQuantity = By.xpath("//span[@class='spinnerUp spinnerArrow']");
	By quantityText = By.cssSelector(".dtl > b");
	By deleteProduct = By.xpath("(//span[contains(.,'Sil')])[1]");
	By emptyBasket = By.cssSelector(".cartEmptyText > .title");
	public SearchAndResultPage sendkeyAndSearch (String searchkey) throws AWTException {
		clearAndSendKeys(getSearchBox, searchkey);
		hitEnter();
		return this;
	}

	public SearchAndResultPage goToSecondPageAndVerify() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//a[contains(@class,'next navigation')]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
		Assert.assertTrue(getTextBy(activePage).equals("2"));  		//verify the second page
		return this;

	}
	public  SearchAndResultPage selectProductAndBasketSteps() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        WebElement webElement = driver.findElement(By.xpath("(//h3[contains(@class,'productName bold')])[6]"));
        executor.executeScript("arguments[0].click()", webElement);

        WebElement webElement1 = driver.findElement(By.partialLinkText("Sepete Ekle")); //Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        executor.executeScript("arguments[0].click()", webElement1);
		Assert.assertTrue(getTextBy(productPrice).equals(getTextBy(basketPrice)));

        WebElement webElement2 = driver.findElement(By.cssSelector(".btnGoBasket")); //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        executor.executeScript("arguments[0].click()", webElement2);
        WebElement webElement3 = driver.findElement(By.xpath("//span[@class='spinnerUp spinnerArrow']"));
        executor.executeScript("arguments[0].click()", webElement3);
		Thread.sleep(2000);
		Assert.assertTrue(getTextBy(quantityText).equals("Toplam 2 ürün"));
        WebElement webElement4 = driver.findElement(deleteProduct);
        executor.executeScript("arguments[0].click()", webElement4);
        Assert.assertTrue(getTextBy(emptyBasket).equals("Sepetiniz Boş"));

		return this;
	}






	
	
	

}
