package Utils;

import Pages.HomePages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;


public class Tools {

    //Siteye girdiğimizi kontrol ediyoruz.
    public void verifyContainsText(WebElement element, String msg)
    {
        Assert.assertTrue(element.getText().toLowerCase().contains(msg.toLowerCase()));


}}

