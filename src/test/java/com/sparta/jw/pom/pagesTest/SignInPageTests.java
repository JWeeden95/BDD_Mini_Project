package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.MyAccountPage;
import com.sparta.jw.pom.pages.SignInPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInPageTests {
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
    @DisplayName("Sign in page to my account page")
    public void signInPageToMyAccountPage() {
        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPage();
        MyAccountPage myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage.getUrl());
    }

    @AfterAll
    static void breakDown(){
        webDriver.quit();
    }
}
