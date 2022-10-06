package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationXMLReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManager {

    static WebDriver driver;

    static void setupDriver(){
        //Tarayıcı driverları.

        Logger.getLogger("").setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void quitDriver(){
        driver.quit();
    }

    }