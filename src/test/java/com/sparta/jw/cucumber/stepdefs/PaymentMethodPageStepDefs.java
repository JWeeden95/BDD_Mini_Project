package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.PaymentMethodPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class PaymentMethodPageStepDefs {
    private WebDriver webDriver;

    @Given("I am on the Payment Method Page")
    public void iAmOnThePaymentMethodPage() {

    }

    @When("I click {string}")
    public void iClickPayByBankWire() {
        PaymentMethodPage.payByBankWire();
    }

    @Then("The bank wire payment page appears")
    public void theBankWirePaymentPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment", webDriver.getCurrentUrl());
    }
}
