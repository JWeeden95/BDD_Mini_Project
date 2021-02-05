package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SummaryPageTester {

    WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, 30);

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
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&step=1", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @Test
    @DisplayName("Testing the cart amount on the cart summary page")
    public void cartAmountCheckOnSummaryPage() {
        boolean isTheCartAmountCorrect;
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

    @Test
    @DisplayName("Testing the plus button on the summary page")
    public void testingPlusButtonOnTheSummaryPage() throws InterruptedException {
        boolean isTheCartAmountCorrect;
        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPageFromHomePage();
        MyAccountPage myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        SummaryPage summaryPage = homePage.goToSummaryPageFromHomePage();
        summaryPage.clickPlusButtonOnTheSummaryPage();
        Thread.sleep(2000);
        isTheCartAmountCorrect = summaryPage.correctCartAmountOnTheSummaryPage(2);
        Assertions.assertTrue(isTheCartAmountCorrect);
        webDriver.close();
    }

    @Test
    @DisplayName("Testing the plus button on the summary page")
    public void testingMinusButtonOnTheSummaryPage() throws InterruptedException {
        boolean isTheCartAmountCorrect;
        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPageFromHomePage();
        MyAccountPage myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        SummaryPage summaryPage = homePage.goToSummaryPageFromHomePage();
        summaryPage.clickPlusButtonMultiTimesOnTheSummaryPage(1);
        Thread.sleep(2000);
        summaryPage.clickMinusButtonOnTheSummaryPage();
        Thread.sleep(2000);
        isTheCartAmountCorrect = summaryPage.correctCartAmountOnTheSummaryPage(1);
        Assertions.assertTrue(isTheCartAmountCorrect);
        webDriver.close();
    }
}