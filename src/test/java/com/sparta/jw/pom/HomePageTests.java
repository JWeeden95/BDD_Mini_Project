package com.sparta.jw.pom;

import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.SignInPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    @DisplayName("Test with POM")
    public void commentsLinkTestWithPOM() {
        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPage();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", signInPage.getUrl());
    }

    @AfterAll
    static void breakDown(){
        webDriver.quit();
    }
}
