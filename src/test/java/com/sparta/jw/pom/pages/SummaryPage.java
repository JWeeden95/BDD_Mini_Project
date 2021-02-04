package com.sparta.jw.pom.pages;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage {
    //http://automationpractice.com/index.php?controller=order
    private static WebDriver webDriver;
    private static String summaryPageLink = "http://automationpractice.com/index.php?controller=order";
    public SummaryPage(WebDriver driver) {
        webDriver = driver;
    }


    public void goToSummaryPage() {
        webDriver.get(summaryPageLink);
    }

    public AddressPage goToAddressPage() {
        webDriver.findElement(By.linkText("Proceed to checkout")).click();
        return new AddressPage(webDriver);
    }
    public static boolean correctCartAmountOnTheSummaryPage(int itemCount) {
        String total = webDriver.findElement(By.id("summary_products_quantity")).getText();
        String itemCountInString = itemCount + "";
        return total.contains(itemCountInString);
    }

    //Added by me for testing on LetsDoThis class, remove if you need to (JF)
    public WebDriver clickProceedToCheckoutAtSummaryPageNoSignIn() {
        webDriver.findElement(By.linkText("Proceed to checkout")).click();
        return webDriver;
    }

}
