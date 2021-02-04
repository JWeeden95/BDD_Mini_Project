package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.fail;

public class HomePageTests {

    static WebDriver webDriver;
    private HomePage homePage;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
    }

    @AfterEach
    void closeBrowser() {
        //webDriver.close();
    }

    @Test
    @DisplayName("Home page to end")
    public void homePageToSignInPage() {
        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPageFromHomePage();
        MyAccountPage myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        SummaryPage summaryPage = homePage.goToSummaryPageFromHomePage();
        AddressPage addressPage = summaryPage.goToAddressPageFromSummaryPage();
        ShippingPage shippingPage = addressPage.goToShippingPageFromAddressPage();
        shippingPage.clickConfirmCheckbox();
        PaymentMethodPage paymentMethodPage = shippingPage.goToPaymentMethodPageFromShippingPage();
        BankWirePaymentPage bankWirePaymentPage = paymentMethodPage.goToBankWirePaymentPageFromPaymentMethodPage();
        PaymentConfirmationPage paymentConfirmationPage = bankWirePaymentPage.goToPaymentConfirmationPageFromBankWirePaymentPage();
        System.out.println(paymentConfirmationPage.getUrl());
    }

//    @Test
//    @DisplayName("GoToSummaryPage goes to the correct page")
//    void goToSummaryPageGoesToTheCorrectPage() {
//        homePage.goToHomePage();
//        homePage.addFirstItemToBasket();
//        homePage.goToSummaryPageFromHomePage();
//    }

    @AfterAll
    static void breakDown(){
        webDriver.quit();
    }
}
