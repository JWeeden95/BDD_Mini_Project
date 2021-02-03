package com.sparta.jw.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SummaryPage {
    WebDriver webDriver;
    @Given("I am on the order summary page")
    public void iAmOnTheOrderSummaryPage() {
        webDriver.getCurrentUrl();
    }

    @And("I have {int} item")
    public void iHaveItem(int arg0) {
    }

    @When("I click proceed to checkout")
    public void iClickProceedToCheckout() {
    }

    @Then("Address page appears")
    public void addressPageAppears() {
    }
}
