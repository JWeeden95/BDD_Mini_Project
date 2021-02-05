package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToTrolleySD {

    private static WebDriver webDriver = new ChromeDriver();
    private static HomePage homePage;

    @Given("I have access to homePage for addCart")
    public void iHaveAccessToPage() {
        homePage = new HomePage(webDriver);
    }

    @When("I click on the add to cart button of an item")
    public void iClickOnTheAddToCartButtonOfAnItem() {
        homePage.addFirstItemToBasket();
        webDriver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span")).click();
    }

    @Then("The cart total will change to {int}")
    public void theCartTotalWillChangeTo(int arg0) {
        Assertions.assertTrue(homePage.correctCartAmount(webDriver, arg0));
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }
}
