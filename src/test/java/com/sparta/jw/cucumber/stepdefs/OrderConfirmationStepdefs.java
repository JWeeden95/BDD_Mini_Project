package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.BankWirePaymentPage;
import com.sparta.jw.pom.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationStepdefs {

    private BankWirePaymentPage bankWirePaymentPage;
    private WebDriver webDriver;

    @Given("that I am on the bank wire page")
    public void thatIAmOnTheBankWirePage() {
        bankWirePaymentPage = new BankWirePaymentPage(webDriver);
    }

    @When("I click confirm order")
    public void iClickConfirmOrder() {
        bankWirePaymentPage.goToPaymentConfirmationPage();
    }

    @Then("the order confirmation page appears")
    public void theOrderConfirmationPageAppears() {
    }

}
