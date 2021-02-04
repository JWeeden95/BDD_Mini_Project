package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentMethodPageTests {
    WebDriver webDriver = new ChromeDriver();
    HomePage homePage;
    SummaryPage summaryPage;
    ShippingPage shippingPage;
    PaymentMethodPage paymentMethodPage;


    @Test
    @DisplayName("Testing Payment Method Page")
    void testingPaymentMethodPage() {
        HomePage homePage = new HomePage(webDriver);
        homePage.goToHomePage();
        homePage.goToSignInPage();
        webDriver.findElement(By.name("email")).sendKeys("");
        webDriver.findElement(By.name("passwd")).sendKeys("");
        webDriver.findElement(By.name("SubmitLogin")).click();
        webDriver.findElement(By.className("home")).click();
        homePage.addFirstItemToBasket();
        homePage.goToSummaryPageFromHomePage();
        SummaryPage summaryPage = new SummaryPage(webDriver);
        summaryPage.goToAddressPageFromSummaryPage();
        webDriver.findElement(By.name("processAddress")).click();
        ShippingPage shippingPage = new ShippingPage(webDriver);
        shippingPage.clickConfirmCheckbox();
        shippingPage.clickGoToPaymentMethodPage();
        PaymentMethodPage paymentMethodPage = new PaymentMethodPage(webDriver);
        paymentMethodPage.goToPayByBankWire();
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment", webDriver.getCurrentUrl());
        BankWirePaymentPage bankWirePaymentPage = new BankWirePaymentPage(webDriver);
//        bankWirePaymentPage.goToPaymentConfirmationPage();
        webDriver.findElement(By.className("icon-chevron-right right")).click();

    }



}
