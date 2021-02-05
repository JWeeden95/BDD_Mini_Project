package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.AuthenticationPage;
import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.MyAccountPage;
import com.sparta.jw.pom.pages.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationStepdefs {

    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private AuthenticationPage authenticationPage;

    @Given("I am on the authentication page")
    public void iAmOnTheAuthenticationPage() {
        signInPage = homePage.goToSignInPageFromHomePage();
        authenticationPage = signInPage.goToAuthenticationPageBadEmailAndPassword();
    }

    @When("I click the home button")
    public void iClickTheHomeButton() {
        homePage = authenticationPage.goToHomePageFromAuthenticationPage();
    }

    @Then("I am back on the homepage")
    public void iAmBackOnTheHomepage() {
        Assertions.assertEquals("http://automationpractice.com/index.php", homePage.getUrl());
        webDriver.close();
    }
}
