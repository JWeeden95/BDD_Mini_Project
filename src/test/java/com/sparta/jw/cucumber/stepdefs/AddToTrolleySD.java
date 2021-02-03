package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToTrolleySD {

    private static WebDriver webDriver;
    private static HomePage homePage;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Given("I have access to {string} page")
    public void iHaveAccessToPage(String arg0) {
        Assertions.assertEquals(arg0, webDriver.getCurrentUrl());
        homePage = new HomePage(webDriver);
    }

    @When("I click on the add to cart button of an item")
    public void iClickOnTheAddToCartButtonOfAnItem() {
        homePage.addFirstItemToBasket();
    }

    @Then("The cart total will change to {int}")
    public void theCartTotalWillChangeTo(int arg0) {
        Assertions.assertTrue(homePage.correctCartAmount(webDriver, arg0));
    }
}
