package com.sparta.jw.pom.pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentMethodPage {

    //http://automationpractice.com/index.php?controller=order&multi-shipping=
    private static WebDriver webDriver;

    public PaymentMethodPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public static void payByBankWire() {
        webDriver.findElement(By.className("bankwire")).click();

    }

    public static void PayByCheque() {
        webDriver.findElement(By.className("cheque")).click();

    }

    public static void continueShopping() {
        webDriver.findElement(By.className("button-exclusive btn btn-default"));
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }



}