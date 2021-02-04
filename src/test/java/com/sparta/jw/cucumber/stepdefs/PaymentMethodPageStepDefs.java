package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentMethodPageStepDefs {
    WebDriver webDriver = new ChromeDriver();
    HomePage homePage;
    SummaryPage summaryPage;
    ShippingPage shippingPage;
    PaymentMethodPage paymentMethodPage;

    @Given("I am on the Payment Method Page")
    public void iAmOnThePaymentMethodPage() {
        homePage.goToHomePage();
        homePage.goToSignInPageFromHomePage();
        webDriver.findElement(By.name("email")).sendKeys("greg.spratt@icloud.com");
        webDriver.findElement(By.name("passwd")).sendKeys("honsoc-6Qekhi-hijqax");
        webDriver.findElement(By.name("SubmitLogin")).click();
        webDriver.findElement(By.className("home")).click();
        homePage.addFirstItemToBasket();
        homePage.goToSummaryPageFromHomePage();
        summaryPage.goToAddressPageFromSummaryPage();
        webDriver.findElement(By.name("processAddress")).click();
        shippingPage.clickConfirmCheckbox();
        shippingPage.goToPaymentMethodPageFromShippingPage();

    }

    @When("I click pay by bank wire")
    public void iClickPayByBankWire() {
        paymentMethodPage.goToBankWirePaymentPageFromPaymentMethodPage();
    }

    @Then("The bank wire payment page appears")
    public void theBankWirePaymentPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment", webDriver.getCurrentUrl());
    }
}
