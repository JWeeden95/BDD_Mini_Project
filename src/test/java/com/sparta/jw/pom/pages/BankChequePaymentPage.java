package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankChequePaymentPage extends Page {
    By confirmOrder = new By.ByXPath("//*[@id=\"cart_navigation\"]/button");
    By goBackToPaymentPage = new By.ByXPath("//*[@id=\"cart_navigation\"]/a");


    public BankChequePaymentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ChequePaymentConfirmationPage goToPaymentConfirmationPageFromChequePaymentPage() {
        webDriver.findElement(confirmOrder).click();
        return new ChequePaymentConfirmationPage(webDriver);
    }

    public PaymentMethodPage goBackToPaymentConfirmationPageFromBankChequePaymentPage() {
        webDriver.findElement(goBackToPaymentPage).click();
        return new PaymentMethodPage(webDriver);
    }
}

