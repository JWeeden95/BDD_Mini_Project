package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends Page{

    //http://automationpractice.com/index.php?controller=order
    public SummaryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public AddressPage goToAddressPageFromSummaryPage() {
        webDriver.findElement(By.linkText("Proceed to checkout")).click();
        return new AddressPage(webDriver);
    }
    public boolean correctCartAmountOnTheSummaryPage(int itemCount) {
        String total = webDriver.findElement(By.id("summary_products_quantity")).getText();
        String itemCountInString = itemCount + "";
        return total.contains(itemCountInString);
    }
    public void clickPlusButtonOnTheSummaryPage(){
        webDriver.findElement(By.className("icon-plus")).click();
    }

    //Added by me for testing on LetsDoThis class, remove if you need to (JF)
    public WebDriver clickProceedToCheckoutAtSummaryPageNoSignIn() {
        webDriver.findElement(By.linkText("Proceed to checkout")).click();
        return webDriver;
    }

}
