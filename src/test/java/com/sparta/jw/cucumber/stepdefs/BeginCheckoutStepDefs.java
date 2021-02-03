package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeginCheckoutStepDefs {

    private WebDriver webDriver;
    private HomePage homePage;

    @Before
    void setup() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
    }

    @Given("I have clicked add to cart")
    public void iHaveClickedAddToCart() {
        homePage.addFirstItemToBasket();
    }

    @When("I click proceed to checkout")
    public void iClickProceedToCheckout() {
        homePage.clickProceedToCheckout();
    }

    @Then("The order summary page appears")
    public void theOrderSummaryPageAppears() {
        // TODO: insert assertion here
    }
}
