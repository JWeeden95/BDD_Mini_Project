package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageStepdefs {

    private WebDriver webDriver;
    private HomePage homePage;
    private SignInPage signInPage;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
    }

    @Given("I am on the initial home page")
    public void iAmOnTheInitialHomePage() {
        homePage.goToHomePage();
    }

    @When("I click sign in")
    public void iClickSignIn() {
        signInPage = homePage.goToSignInPageFromHomePage();
    }

    @Then("The sign in page appears")
    public void theSignInPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", signInPage.getUrl());
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }

}
