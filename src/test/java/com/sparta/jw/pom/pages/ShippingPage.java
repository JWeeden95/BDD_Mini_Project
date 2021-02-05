package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends Page{

    By termsOfService = new By.ById("cgv");

    public ShippingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickConfirmCheckbox() {
        webDriver.findElement(termsOfService).click();
    }

    public boolean checkConfirmationCheckboxHasBeenTicked() {
        return webDriver.findElement(termsOfService).isEnabled();
    }

    public PaymentMethodPage goToPaymentMethodPageFromShippingPage() {
        webDriver.findElement(By.name("processCarrier")).click();
        return new PaymentMethodPage(webDriver);
    }

    public AddressPage goToAddressPageFromShippingPage() {
        webDriver.findElement(By.xpath("//*[@id=\"form\"]/p/a")).click();
        return new AddressPage(webDriver);
    }

    public HomePage goToHomePageFromShippingPage() {
        webDriver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a/i")).click();
        return new HomePage(webDriver);
    }


    //http://automationpractice.com/index.php?controller=order
}
