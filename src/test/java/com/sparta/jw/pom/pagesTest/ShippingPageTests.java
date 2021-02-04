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
        shippingPage.clickGoToPaymentMethodPage();
        System.out.println(shippingPage.getUrl());
    }

    @Test
    public void runAll(){

//        First need to go to home page
//                - Homepage object
        homePage = new HomePage(webDriver);

//        Add an item to basket
//              - Use homepage methods to add
//              - create summary page and go to it
        homePage.addFirstItemToBasket();
        summaryPage = new SummaryPage(homePage.homeDriver());
        summaryPage.goToSummaryPage("http://automationpractice.com/index.php?controller=order");

//        Summary page
//              - create login page and go to it
        signInPage = new SignInPage(summaryPage.clickProceedToCheckoutAtSummaryPageNoSignIn());

//        Login page
//              - create Addresses page
//              - Enter login details and go to Addresses

//        TODO: Add login details
        webDriver.findElement(By.cssSelector("#email")).sendKeys();
        webDriver.findElement(By.cssSelector("#passwd")).sendKeys();
        webDriver.findElement(By.id("SubmitLogin")).click();
        addressPage = new AddressPage(webDriver);

//        Addresses
//              - Check addresses
//              - Check comments
//              - create Shipping page

        webDriver.findElement(By.id("order")).click();
        Assertions.assertTrue(addressPage.isCommentEmpty());

    }
}
