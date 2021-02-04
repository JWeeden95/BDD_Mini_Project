package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageStepdefs {

    private WebDriver webDriver;
    private HomePage homePage;

    @Before
    void setup() {
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
    }

    @When("I click sign in")
    public void iClickSignIn() {
    }

    @Then("The sign in page appears")
    public void theSignInPageAppears() {
    }
}
