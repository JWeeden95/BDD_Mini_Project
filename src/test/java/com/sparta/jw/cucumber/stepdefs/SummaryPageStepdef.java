package com.sparta.jw.cucumber.stepdefs;


import com.sparta.jw.pom.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SummaryPageStepdef {

    WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SummaryPage summaryPage;
    private AddressPage addressPage;
    private SignInPage signInPage;

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
        boolean isTheCartAmountCorrect;
        isTheCartAmountCorrect = summaryPage.correctCartAmountOnTheSummaryPage(arg0);
        Assertions.assertTrue(isTheCartAmountCorrect);
        webDriver.close();
    }

    @When("I click on the minus button next to the item")
    public void iClickOnTheMinusButtonNextToTheItem() throws InterruptedException {
        summaryPage.clickMinusButtonOnTheSummaryPage();
        Thread.sleep(2000);
    }

    @Given("I am on the order summary page and i have {int} items in the basket")
    public void iAmOnTheOrderSummaryPageAndIHaveItemsInTheBasket(int arg0) throws InterruptedException {

        homePage.goToHomePage();
        SignInPage signInPage = homePage.goToSignInPageFromHomePage();
        MyAccountPage myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        summaryPage.clickPlusButtonMultiTimesOnTheSummaryPage(1);
        Thread.sleep(2000);
    }

    @Then("Alternate signing page appears")
    public void alternateSigningPageAppears() {
        //Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0",signInPage.getUrl());
        Assertions.assertTrue(signInPage.hasOrderStepBar());
        webDriver.quit();
    }

    @When("I click proceed to checkout from Summary page with no signin")
    public void iClickProceedToCheckoutFromSummaryPageWithNoSignin() {
        signInPage = summaryPage.goToSigninPageFromSummaryPage();
    }

    @Given("I am on the order summary page nosignin")
    public void iAmOnTheOrderSummaryPageNosignin() {
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
    }
}
