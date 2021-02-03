package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankWirePaymentPage {

    //http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment
    private WebDriver webDriver;
    By confirmOrder = new By.ByClassName("button btn btn-default button-medium");

    public BankWirePaymentPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.findElement(By.className("bankwire")).click();
    }

    public PaymentConfirmationPage goToPaymentConfirmationPage() {
        webDriver.findElement(confirmOrder).click();
        return new PaymentConfirmationPage(webDriver);
    }

}
