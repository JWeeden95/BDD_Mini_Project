package com.sparta.jw.pom;

import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.SummaryPage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SummaryPageTester {
    static WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        SummaryPage summaryPage = new SummaryPage(webDriver);
    }

    @Test
    @DisplayName("Clicking the proceed to checkout button")
    public void clickCheckoutButton(){
        SummaryPage summaryPage = new SummaryPage(webDriver);
        summaryPage.goToSummaryPage("http://automationpractice.com/index.php?controller=order");
        summaryPage.clickProceedToCheckoutAtSummaryPage();

    }

}
