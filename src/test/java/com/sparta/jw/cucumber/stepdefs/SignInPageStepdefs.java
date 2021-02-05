package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.MyAccountPage;
import com.sparta.jw.pom.pages.SignInPage;
import com.sparta.jw.pom.pages.SummaryPage;
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

    @Given("I am on the sign in page")
    public void iAmOnTheSignInPage() {
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPageFromHomePage();
    }

    @And("I have filled in the correct username and password")
    public void iHaveFilledInTheCorrectUsernameAndPassword() {
    }

    @When("I press enter")
    public void iPressEnter() {
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
    }

    @Then("my account page appears")
    public void myAccountPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage.getUrl());
        webDriver.close();
    }

}
