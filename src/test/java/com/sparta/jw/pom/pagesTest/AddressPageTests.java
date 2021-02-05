package com.sparta.jw.pom.pagesTest;

import com.sparta.jw.pom.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AddressPageTests {

    WebDriver webDriver = new ChromeDriver();
    List<String> billing;
    HomePage homePage;
    SummaryPage summaryPage;
    SignInPage signInPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    private static final Properties properties = new Properties();
    private static final String PROPERTIES_PATH = "src/test/resources/userDetails.properties";

    @BeforeEach
    public void setUp(){

        createProperties();
        homePage = new HomePage(webDriver);
        addToBasket();
        setSummaryPage();
        setSignInPage();
        Assertions.assertTrue(addressPage.isCommentEmpty());
        billing = addressPage.getActualBillingAddress();
    }

    @Test
    public void checkAddressIsActual()
    {
        Assertions.assertTrue(addressPage.isBillingAddressAndMyAddressTheSame());
    }

    @Test
    public void changeAddress()
    {
        addressPage.changeBothAddress();
        Assertions.assertFalse(addressPage.isBillingAddressAndMyAddressTheSame());
    }

    @Test
    public void billingChange()
    {
        changeOnlyShipping();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        addressPage.changeBillingAddress(2);
        Assertions.assertTrue(addressPage.isBillingAddressAndMyAddressTheSame());
    }

    public void changeOnlyShipping()
    {
        addressPage.switchOffSameAddress();
    }

    @Test
    public void getToShipping()
    {
        setShippingPage();
        Assertions.assertTrue(webDriver.findElement(By.className("page-heading")).getText().contains("SHIPPING"));
    }

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
        webDriver.findElement(By.name("email")).sendKeys(properties.getProperty("username"));
        webDriver.findElement(By.name("passwd")).sendKeys(properties.getProperty("password"));
        webDriver.findElement(By.id("SubmitLogin")).click();
        addressPage = new AddressPage(webDriver);
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
