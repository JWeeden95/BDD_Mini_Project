package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.HomePage;
import com.sparta.jw.pom.pages.MyAccountPage;
import com.sparta.jw.pom.pages.SignInPage;
import com.sparta.jw.pom.pages.SummaryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAccountStepdefs {

    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;

    @Given("I am on the my account page")
    public void iAmOnTheMyAccountPage() {
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
    }

    @When("I click the home icon")
    public void iClickTheHomeIcon() {
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
    }

    @Then("the home page appears")
    public void theHomePageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php", homePage.getUrl());
    }
}
