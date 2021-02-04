package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.SummaryPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SummaryPageTester {
    static WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
    }

//    @AfterAll
//    static void tearDown() {
//        webDriver.close();
//    }

    @Test
    @DisplayName("Clicking the proceed to checkout button")
    public void clickCheckoutButton(){
        SummaryPage summaryPage = new SummaryPage(webDriver);
        summaryPage.goToSummaryPage();
        summaryPage.goToAddressPage();
//Write test to test the summary page product counter method


    }
    @Test
    @DisplayName("Testing the cart amount on the cart summary page")
    public void cartAmountCheckOnSummaryPage(){
        SummaryPage summaryPage = new SummaryPage(webDriver);
        summaryPage.goToSummaryPage();
        summaryPage.goToAddressPage();
//Write test to test the summary page product counter method


    }
}