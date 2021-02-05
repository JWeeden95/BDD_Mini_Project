package com.sparta.jw.pom.pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentMethodPage extends Page{

    //http://automationpractice.com/index.php?controller=order&multi-shipping=

    public PaymentMethodPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public BankWirePaymentPage goToBankWirePaymentPageFromPaymentMethodPage() {
        webDriver.findElement(By.className("bankwire")).click();
        return new BankWirePaymentPage(webDriver);

    }

//    public static BankChequePaymentPage goToPayByCheque() {
//        webDriver.findElement(By.className("cheque")).click();
//        return new BankChequePaymentPage(webDriver);
//
//    }

    public ShippingPage clickContinueShoppingFromPaymentMethodPage() {
        webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/a")).click();
        return new ShippingPage(webDriver);
    }

    public ShippingPage goToShippingPageFromPaymentMethodPage() {
        webDriver.findElement(By.xpath("//*[@id=\"order_step\"]/li[4]/a")).click();
        return new ShippingPage(webDriver);
    }

    public AddressPage goToAddressPageFromPaymentMethodPage() {
        webDriver.findElement(By.xpath("//*[@id=\"order_step\"]/li[3]/a")).click();
        return new AddressPage(webDriver);
    }

    public SummaryPage goToSummaryPageFromPaymentMethodPage() {
        webDriver.findElement(By.xpath("//*[@id=\"order_step\"]/li[1]/a")).click();
        return new SummaryPage(webDriver);
    }

    public HomePage goToHomePageFromPaymentMethodPage(){
        webDriver.findElement(By.className("icon-home")).click();
        return new HomePage(webDriver);
    }

}



