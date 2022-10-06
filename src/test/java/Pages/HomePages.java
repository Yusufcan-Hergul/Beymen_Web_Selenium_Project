package Pages;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.util.logging.Logger;

public class HomePages {

    public HomePages() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    @FindBy(xpath = "//a[@title=\"Beymen\"]")
    public WebElement title;
    //Site girişi onayı.

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCokies;
    //Çerezler.

    @FindBy(xpath = "//input[@placeholder='Ürün, Marka Arayın']")
    public WebElement searchBar;
    //AramaButonu.







        }

