package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankWirePaymentPage extends Page{

    //http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment
    By confirmOrder = new By.ByClassName("button btn btn-default button-medium");
    By goBackToPaymentPage = new By.ByClassName("button-exclusive btn btn-default");

    public BankWirePaymentPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public PaymentConfirmationPage goToPaymentConfirmationPageFromBankWirePaymentPage() {
        webDriver.findElement(confirmOrder).click();
        return new PaymentConfirmationPage(webDriver);
    }

    public PaymentMethodPage goBackToPaymentConfirmationPage() {
        webDriver.findElement(goBackToPaymentPage).click();
        return new PaymentMethodPage(webDriver);
    }
}
