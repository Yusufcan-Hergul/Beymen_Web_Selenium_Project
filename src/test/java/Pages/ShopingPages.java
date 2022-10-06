package Pages;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingPages {

    public ShopingPages() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/p_beymen-collection-pembe-nakisli-midi-saten-gomlek-elbise_988288']")
    public WebElement Product;
    //Seçilen Ürün.

    @FindBy(xpath = "//ins[@class='m-price__new']")
    public WebElement price;
    //Ürün fiyatı.

    @FindBy(xpath = "//span[@class='o-productDetail__description']")
    public WebElement ProductDetails;
    //Ürün detayları.

    @FindBy(xpath = "//span[@class='m-variation__item']")
    public WebElement SizeOfTheProduct;
    //Ürün bedeni.

    @FindBy(id = "addBasket")
    public WebElement addBasket;
    //Ürün sepete ekleme.

    @FindBy(xpath = "//a[@href='/cart'][1]")
    public WebElement basket;
    //Sepet.

    @FindBy(xpath = "//span[@class='m-productPrice__salePrice']")
    public WebElement priceİnTheBasket;
    //Sepetteki fiyat.

    @FindBy(xpath = "//select[@id='quantitySelect0-key-0']")
    public WebElement QuantityNumber;
    //Ürün sayısı.

    @FindBy(xpath = "//option[@value='2']")
    public WebElement changeNumber;
    //Ürün sayısını 2 yap.

    @FindBy(xpath = "//button[@id='removeCartItemBtn0-key-0']")
    public WebElement Delete;
    //Ürünü sil.

    @FindBy(xpath = "//strong[@class='m-empty__messageTitle']")
    public WebElement verifyDelete;
}
