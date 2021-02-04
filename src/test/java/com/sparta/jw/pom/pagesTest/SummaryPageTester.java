package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SummaryPageTester {

    boolean isTheCartAmountCorrect;
    WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);

    @Test
    @DisplayName("Clicking the proceed to checkout button")
    public void clickCheckoutButton() {
        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPageFromHomePage();
        MyAccountPage myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        SummaryPage summaryPage = homePage.goToSummaryPageFromHomePage();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
        AddressPage addressPage = summaryPage.goToAddressPageFromSummaryPage();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&step=1",webDriver.getCurrentUrl());
        webDriver.close();
    }

    @Test
    @DisplayName("Testing the cart amount on the cart summary page")
    public void cartAmountCheckOnSummaryPage() {
        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPageFromHomePage();
        MyAccountPage myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        SummaryPage summaryPage = homePage.goToSummaryPageFromHomePage();
        isTheCartAmountCorrect = summaryPage.correctCartAmountOnTheSummaryPage(1);
        Assertions.assertTrue(isTheCartAmountCorrect);
        webDriver.close();
    }

}