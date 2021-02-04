package com.sparta.jw.pom;

import com.sparta.jw.pom.pages.AddressPage;
import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.SignInPage;
import com.sparta.jw.pom.pages.SummaryPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;

public class LetsDoThis {

    WebDriver driver = new ChromeDriver();
    HomePage homePage;
    SummaryPage summaryPage;
    SignInPage signInPage;
    AddressPage addressPage;

    @Test
    public void runAll(){

//        First need to go to home page
//                - Homepage object
        homePage = new HomePage(driver);

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
        driver.findElement(By.cssSelector("#email")).sendKeys("greg.spratt@icloud.com");
        driver.findElement(By.cssSelector("#passwd")).sendKeys("honsoc-6Qekhi-hijqax");
        driver.findElement(By.id("SubmitLogin")).click();
        addressPage = new AddressPage(driver);

//        Addresses
//              - Check addresses
//              - Check comments
//              - create Shipping page
        Assertions.assertTrue(addressPage.isCommentEmpty());

    }
}
