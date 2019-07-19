package tests;

import org.testng.annotations.Test;
import pages.SearchAndResultPage;

import java.awt.*;

public class SearchAndResultTest extends  BaseTest{

    @Test(priority = 1)
    public void sendkeySearchAndChoose() throws AWTException, InterruptedException {
        SearchAndResultPage sendkeySearchAndChooseTest = new SearchAndResultPage(driver);
        sendkeySearchAndChooseTest
                .sendkeyAndSearch("bilgisayar");
        System.out.println("Bilgisayar texti aratma ve yazdırma başarılı");

    }


    @Test(priority = 2)
    public void goToSecondPageAndVerify() throws AWTException, InterruptedException {
        SearchAndResultPage secondPageSteps = new SearchAndResultPage(driver);
        secondPageSteps
                .goToSecondPageAndVerify();
        System.out.println("İkinciyi sayfaya geçme ve kontrol etme başarılı");
    }
    @Test(priority = 3)
    public void selectProductAndBasketSteps() throws AWTException, InterruptedException {
        SearchAndResultPage productBasketCases = new SearchAndResultPage(driver);
        productBasketCases
                .selectProductAndBasketSteps();
        System.out.println("Ürün seçme ,kontrol etme , sepete gitme , adet artırma , silme , boş sepet kontrol başarılı");
    }
}
