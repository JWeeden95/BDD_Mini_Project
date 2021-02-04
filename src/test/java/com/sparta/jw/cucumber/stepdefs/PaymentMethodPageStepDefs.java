package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentMethodPageStepDefs {
    WebDriver webDriver = new ChromeDriver();
    HomePage homePage;
    SummaryPage summaryPage;
    SignInPage signInPage;
    AddressPage addressPage;

    @Given("I am on the Payment Method Page")
    public void iAmOnThePaymentMethodPage() {
        homePage.goToHomePage();
        homePage.goToSignInPage();

    }

    @When("I click {string}")
    public void iClickPayByBankWire() {
        PaymentMethodPage.goToPayByBankWire();
    }

    @Then("The bank wire payment page appears")
    public void theBankWirePaymentPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment", webDriver.getCurrentUrl());
    }
}
