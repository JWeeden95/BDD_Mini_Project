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
    public SignInPage goToSigninPageFromSummaryPage() {
        webDriver.findElement(By.linkText("Proceed to checkout")).click();
        return new SignInPage(webDriver);
    }
    public boolean correctCartAmountOnTheSummaryPage(int itemCount) {
        String total = webDriver.findElement(By.id("summary_products_quantity")).getText();
        String itemCountInString = itemCount + "";
        return total.contains(itemCountInString);
    }
    public void clickPlusButtonOnTheSummaryPage(){
        webDriver.findElement(By.className("icon-plus")).click();
    }
    public void clickMinusButtonOnTheSummaryPage(){
        webDriver.findElement(By.className("icon-minus")).click();
    }
    public void clickMinusButtonMultiTimesOnTheSummaryPage(int number){
        for (int i = 0;i<number;i++) {
            webDriver.findElement(By.className("icon-minus")).click();
        }
    }
    public void clickPlusButtonMultiTimesOnTheSummaryPage(int number){
        for (int i = 0;i<number;i++) {
            webDriver.findElement(By.className("icon-plus")).click();
        }
    }
    public void clickTheDeleteButtonOnSummaryPage(){
        webDriver.findElement(By.className("cart_quantity_delete")).click();
    }
    public boolean isMyCartEmpty(){
        return webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).isDisplayed();
    }
    //Added by me for testing on LetsDoThis class, remove if you need to (JF)
    public WebDriver clickProceedToCheckoutAtSummaryPageNoSignIn() {
        webDriver.findElement(By.linkText("Proceed to checkout")).click();
        return webDriver;
    }

}
