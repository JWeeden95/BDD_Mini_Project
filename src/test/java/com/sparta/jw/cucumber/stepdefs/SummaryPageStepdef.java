package com.sparta.jw.cucumber.stepdefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SummaryPageStepdef {
    String SummaryPageURL;
    boolean isTheCartAmountCorrect;

    @Given("I am on the order summary page")
    public void iAmOnTheOrderSummaryPage() {
    }

    @And("I have {int} item")
    public void iHaveSomethingInMyCart(int arg0) {
    }

    @When("I click proceed to checkout from Summary page")
    public void iClickProceedToCheckoutFromSummaryPage() {
    }

    @Then("Address page appears")
    public void addressPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", SummaryPageURL);
        Assertions.assertTrue(isTheCartAmountCorrect);
    }
}
