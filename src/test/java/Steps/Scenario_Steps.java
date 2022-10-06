package Steps;

import Pages.HomePages;
import Pages.ShopingPages;
import Utils.DriverManager;
import Utils.Excel_Utility;
import Utils.Tools;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Scenario_Steps {

    HomePages pages = new HomePages();

    ShopingPages shopingPages = new ShopingPages();

    //Excel dosyasının yolunu belirliyor.
    String path = "src/test/java/resources/BeymenTask1.xlsx";

    //2d halindeki excel dosyasının yolunu belirliyor.
    List<List<String>> list = Excel_Utility.getData(path, "Sayfa1", 2);

    WebDriver driver = DriverManager.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Given("User open the web.")
    public void userOpenTheWeb() {
        //Tarayıcıya bağlantıyı gönderiyoruz.

        driver.get("https://www.beymen.com/");
        wait.until(ExpectedConditions.elementToBeClickable(pages.acceptCokies));
        pages.acceptCokies.click();
    }

    @When("Verify open the web.")
    public void verifyOpenTheWeb() {
        //Sitenin açıldığını kontrol ediyoruz.

        Assert.assertTrue(pages.title.isDisplayed());

    }

    @And("Put the search bar first sentence.")
    public void putTheSearchBarFirstSentence() {
        //Arama bölümüne 'Şort' yazdırıyoruz.

        pages.searchBar.sendKeys (list.get(0).get(0));

    }

    @But("Clean the sentence.")
    public void cleanTheSentence() {
        //Kelimeyi siliyoruz.

        pages.searchBar.sendKeys(Keys.CONTROL + "A" + Keys.BACK_SPACE);
    }

    @Then("Put the search bar second sentence.")
    public void putTheSearchBarSecondSentence() {
        //Arama bölümüne 'Gömlek' yazdırıyoruz.

        pages.searchBar.sendKeys(list.get(0).get(1));

    }

    @And("Click the Enter key.")
    public void clickTheEnterKey() throws InterruptedException {
        //Arama butonuna basıyoruz.

        pages.searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Then("Select a random product.")
    public void selectARandomProduct() {
        //Ürünü seçiyoruz.

        shopingPages.Product.click();
    }

    @And("Write the price and detail about the product as txt document.")
    public void writeThePriceAndDetailAboutTheProductAsTxtDocument() throws InterruptedException {

        Thread.sleep(2000);

        //Ürün bilgileri txt dosyasına yazdırılır.
        FileWriter fw= null;
        String path="src/test/java/resources/UrunDetaylari";
        try {
            fw = new FileWriter(path);
            PrintWriter pw=new PrintWriter(fw);
            pw.println("Price details :" +shopingPages.price.getText());
            pw.println("Product details :" +shopingPages.ProductDetails.getText());
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Add shopping cart the selected product.")
    public void addShoppingCartTheSelectedProduct() {

        //Ürün sepete eklenir.
        wait.until(ExpectedConditions.elementToBeClickable(shopingPages.SizeOfTheProduct));
        shopingPages.SizeOfTheProduct.click();
        wait.until(ExpectedConditions.elementToBeClickable(shopingPages.addBasket));
        shopingPages.addBasket.click();
        wait.until(ExpectedConditions.elementToBeClickable(shopingPages.basket));
        shopingPages.basket.click();
    }

    @Then("Compare price about the product in the shopping cart and in the web.")
    public void comparePriceAboutTheProductInTheShoppingCartAndInTheWeb() {

        //Homedaki ürün ile sepetteki ününün fiyatı karşılaştırılır.
        if (shopingPages.price == shopingPages.priceİnTheBasket)
            System.out.println("Sepetteki fiyatla aynı.");

        else { System.out.println("Fiyatlar aynı değil");
        }
    }

    @Then("Making number of the product second and verify the product number.")
    public void makingNumberOfTheProductSecondAndVerifyTheProductNumber() throws InterruptedException {

        //Ürün sayısı 2 ye arttırılır.
        shopingPages.QuantityNumber.click();
        Thread.sleep(2000);
        shopingPages.changeNumber.click();
    }

    @And("Delete the product in the shopping cart and verify whether or not empty.")
    public void deleteTheProductInTheShoppingCartAndVerifyWhetherOrNotEmpty() {

        //Ürün silinir.
        shopingPages.Delete.click();
        if (shopingPages.verifyDelete.isDisplayed())
            System.out.println("Sepet boş.");
        else {
            System.out.println("Sepet dolu");
        }

    }
}
