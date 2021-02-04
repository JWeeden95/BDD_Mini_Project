package com.sparta.jw.pom.pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentMethodPage {

    //http://automationpractice.com/index.php?controller=order&multi-shipping=
    private WebDriver webDriver;

    public PaymentMethodPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public BankWirePaymentPage goToPayByBankWire() {
        webDriver.findElement(By.className("bankwire")).click();
        return new BankWirePaymentPage(webDriver);

    }

//    public static BankChequePaymentPage goToPayByCheque() {
//        webDriver.findElement(By.className("cheque")).click();
//        return new BankChequePaymentPage(webDriver);
//
//    }

    public ShippingPage clickContinueShoppingFromPaymentMethodPage() {
        webDriver.findElement(By.className("button-exclusive btn btn-default"));
        return new ShippingPage(webDriver);
    }

    public String getUrl(){
        return webDriver.getCurrentUrl();
    }
}

