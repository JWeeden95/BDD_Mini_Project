package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

public class LetsDoThis {

    WebDriver driver = new ChromeDriver();
    HomePage homePage;
    SummaryPage summaryPage;
    SignInPage signInPage;
    AddressPage addressPage;
    private static final Properties properties = new Properties();
    private static final String PROPERTIES_PATH = "src/test/resources/userDetails.properties";

    private static void createProperties() {
        try {
            properties.load(new FileReader(PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runAll(){

        createProperties();
//        First need to go to home page
//                - Homepage object
        homePage = new HomePage(driver);

//        Add an item to basket
//              - Use homepage methods to add
//              - create summary page and go to it
        homePage.addFirstItemToBasket();
        summaryPage = new SummaryPage(homePage.homeDriver());
        driver.get("http://automationpractice.com/index.php?controller=order");

//        Summary page
//              - create login page and go to it
        signInPage = new SignInPage(summaryPage.clickProceedToCheckoutAtSummaryPageNoSignIn());

//        Login page
//              - create Addresses page
//              - Enter login details and go to Addresses
        driver.findElement(By.name("email")).sendKeys(properties.getProperty("username"));
        driver.findElement(By.name("passwd")).sendKeys(properties.getProperty("password"));
        driver.findElement(By.id("SubmitLogin")).click();
        addressPage = new AddressPage(driver);

//        Addresses
//              - Check addresses
//              - Check comments
//              - create Shipping page
        Assertions.assertTrue(addressPage.isCommentEmpty());
        ShippingPage shippingPage = addressPage.goToShipping();
    }
}
