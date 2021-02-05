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

}



