package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends Page{

    By termsOfService = new By.ById("cgv");

    public ShippingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean clickConfirmCheckbox() {
        webDriver.findElement(termsOfService).click();
        return webDriver.findElement(termsOfService).isSelected();

    }

    public PaymentMethodPage goToPaymentMethodPageFromShippingPage() {
        webDriver.findElement(By.name("processCarrier")).click();
        return new PaymentMethodPage(webDriver);
    }
    //http://automationpractice.com/index.php?controller=order
}
