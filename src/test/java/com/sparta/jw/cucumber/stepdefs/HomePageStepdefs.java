package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.MyAccountPage;
import com.sparta.jw.pom.pages.SignInPage;
import com.sparta.jw.pom.pages.SummaryPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageStepdefs {

    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private SummaryPage summaryPage;

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

    @And("I am signed in")
    public void iAmSignedIn() {
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
    }

    @And("I have an item in my basket")
    public void iHaveAnItemInMyBasket() {
        homePage.addFirstItemToBasket();
    }

    @When("I click proceed to checkout from home page")
    public void iClickProceedToCheckoutFromHomePage() {
        summaryPage = homePage.goToSummaryPageFromHomePage();
    }

    @Then("The summary page appears")
    public void theSummaryPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", summaryPage.getUrl());
    }
}
