package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeginCheckoutStepDefs {

    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        homePage.goToHomePage();
    }

    @And("I have clicked add to cart")
    public void iHaveClickedAddToCart() {
        homePage.addFirstItemToBasket();
    }

    @When("I click proceed to checkout from home")
    public void iClickProceedToCheckoutFromHome() {
        homePage.goToSummaryPageFromHomePage();
    }

    @Then("The order summary page appears")
    public void theOrderSummaryPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @And("I have clicked continue shopping")
    public void iHaveClickedContinueShopping() {
        homePage.clickContinueShopping();
    }

    @When("I click the alternative proceed to checkout from home")
    public void iClickTheAlternativeProceedToCheckoutFromHome() {
        homePage.goToSummaryPageFromHomePageAlternative();
    }

}