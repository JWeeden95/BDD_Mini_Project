package com.sparta.jw.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SummaryPageStepdef {
    WebDriver webDriver;
    String SummaryPageURL;
    @Given("I am on the order summary page")
    public void iAmOnTheOrderSummaryPage() {
        SummaryPageURL = webDriver.getCurrentUrl();
    }

    @And("I have {int} item")
    public void iHaveItem(int arg0) {
    }

    @When("I click proceed to checkout from Summary page")
    public void iClickProceedToCheckoutFromSummaryPage() {

    }

    @Then("Address page appears")
    public void addressPageAppears() {
    }
}
