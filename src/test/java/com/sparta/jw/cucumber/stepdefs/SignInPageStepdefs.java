package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInPageStepdefs {

    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private AuthenticationPage authenticationPage;

    @Given("I am on the sign in page")
    public void iAmOnTheSignInPage() {
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPageFromHomePage();
    }

    @And("I have filled in the correct username and password")
    public void iHaveFilledInTheCorrectUsernameAndPassword() {
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
    }

    @When("I press enter")
    public void iPressEnter() {
    }

    @Then("my account page appears")
    public void myAccountPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage.getUrl());
        webDriver.close();
    }

    @And("I fill in the incorrect username but correct password")
    public void iFillInTheIncorrectUsernameButCorrectPassword() {
        authenticationPage = signInPage.goToAuthenticationPageBadEmail();
    }

    @Then("the authentication page appears")
    public void theAuthenticationPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication", authenticationPage.getUrl());
        webDriver.close();
    }

    @And("I fill in the correct username but incorrect password")
    public void iFillInTheCorrectUsernameButIncorrectPassword() {
        authenticationPage = signInPage.goToAuthenticationPageBadPassword();
    }

    @And("I fill in the incorrect username and password")
    public void iFillInTheIncorrectUsernameAndPassword() {
        authenticationPage = signInPage.goToAuthenticationPageBadEmailAndPassword();
    }
}
