package com.sparta.jw.pom.pages;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage {
    //http://automationpractice.com/index.php?controller=order
    private static WebDriver webDriver;

    public SummaryPage(WebDriver driver) {
        webDriver = driver;
    }


    public void goToSummaryPage(String link) {
        webDriver.get(link);
    }

    public AddressPage clickProceedToCheckoutAtSummaryPage() {
        webDriver.findElement(By.linkText("Proceed to checkout")).click();
        return new AddressPage(webDriver);
    }

    //Added by me for testing on LetsDoThis class, remove if you need to (JF)
    public WebDriver clickProceedToCheckoutAtSummaryPageNoSignIn() {
        webDriver.findElement(By.linkText("Proceed to checkout")).click();
        return webDriver;
    }

}
