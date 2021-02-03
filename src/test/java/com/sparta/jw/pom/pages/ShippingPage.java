package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {
    private WebDriver webDriver;

    public ShippingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void confirmCheckbox() {
        webDriver.findElement(By.id("cgv")).click();
    }

    public PaymentMethodPage proceedToCheckout() {
        webDriver.findElement(By.name("processCarrier")).click();
        return new PaymentMethodPage(webDriver);
    }
    //http://automationpractice.com/index.php?controller=order
}
