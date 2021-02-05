package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShippingPageTests {
    static WebDriver webDriver;
    private ShippingPage shippingPage;

    HomePage homePage;
    SummaryPage summaryPage;
    SignInPage signInPage;
    AddressPage addressPage;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        shippingPage = new ShippingPage(webDriver);
    }

    @Test
    @DisplayName("Test with POM")
    void commentsLinkTestWithPOM() {
        shippingPage.clickConfirmCheckbox();
        shippingPage.goToPaymentMethodPageFromShippingPage();
        System.out.println(shippingPage.getUrl());
    }


}
