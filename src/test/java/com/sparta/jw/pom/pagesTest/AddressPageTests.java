package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AddressPageTests {

    WebDriver driver = new ChromeDriver();
    HomePage homePage;
    SummaryPage summaryPage;
    SignInPage signInPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    private static final Properties properties = new Properties();
    private static final String PROPERTIES_PATH = "src/test/resources/userDetails.properties";

    @Test
    public void runAll(){

        createProperties();
//        First need to go to home page
//                - Homepage object
        homePage = new HomePage(driver);

        addToBasket();
        setSummaryPage();
        setSignInPage();
        Assertions.assertTrue(addressPage.isCommentEmpty());
        setShippingPage();
    }

    @Test
    public void addToBasket()
    {
        homePage.addFirstItemToBasket();
    }

    public void setSummaryPage()
    {
        summaryPage = homePage.goToSummaryPageFromHomePage();
        signInPage = new SignInPage(summaryPage.clickProceedToCheckoutAtSummaryPageNoSignIn());
    }

    public void setSignInPage()
    {
        driver.findElement(By.name("email")).sendKeys(properties.getProperty("username"));
        driver.findElement(By.name("passwd")).sendKeys(properties.getProperty("password"));
        driver.findElement(By.id("SubmitLogin")).click();
        addressPage = new AddressPage(driver);
    }

    public void setShippingPage()
    {
        shippingPage = addressPage.goToShippingPageFromAddressPage();
    }

    private static void createProperties() {
        try {
            properties.load(new FileReader(PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
