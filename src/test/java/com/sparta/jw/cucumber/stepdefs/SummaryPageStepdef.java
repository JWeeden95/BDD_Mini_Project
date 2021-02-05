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

public class SummaryPageStepdef {
    boolean isTheCartAmountCorrect;
    WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SummaryPage summaryPage;
    private AddressPage addressPage;

    @Given("I am on the order summary page")
    public void iAmOnTheOrderSummaryPage() {
        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPageFromHomePage();
        MyAccountPage myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
    }

    @And("I have {int} item")
    public void iHaveSomethingInMyCart(int arg0) {
        isTheCartAmountCorrect = summaryPage.correctCartAmountOnTheSummaryPage(arg0);
    }

    @When("I click proceed to checkout from Summary page")
    public void iClickProceedToCheckoutFromSummaryPage() {
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
    }

    @Then("Address page appears")
    public void addressPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&step=1", addressPage.getUrl());
        webDriver.close();
    }

    @When("I click on the plus button next to the item")
    public void iClickOnThePlusButtonNextToTheItem() throws InterruptedException {
        summaryPage.clickPlusButtonOnTheSummaryPage();
        Thread.sleep(4000);
    }

    @Then("the total product counter should be {int}")
    public void theTotalProductCounterShouldBe(int arg0) {
        boolean isTheCartAmountCorrect1;
        isTheCartAmountCorrect1 = summaryPage.correctCartAmountOnTheSummaryPage(arg0);
        Assertions.assertTrue(isTheCartAmountCorrect1);
        webDriver.close();
    }
}
