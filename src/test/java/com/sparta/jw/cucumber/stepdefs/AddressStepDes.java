package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.AddressPage;
import com.sparta.jw.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddressStepDes {

    private static WebDriver webDriver = new ChromeDriver();
    private static AddressPage addressPage;
    HomePage homePage;
    SummaryPage summaryPage;
    ShippingPage shippingPage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;

    @Given("that I am on the Address page")
    public void thatIAmOnPage() {
        homePage = new HomePage(webDriver);
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
    }

    @And("I have left no comment in the comment box")
    public void iHaveLeftNoCommentInTheCommentBox() {
        Assertions.assertTrue(addressPage.isCommentEmpty());
    }

    @And("my billing information is correct")
    public void myBillingInformationIsCorrect() {
        List<String> billing = addressPage.getActualBillingAddress();
        Assertions.assertTrue(addressPage.IsBillingAddressAndMyAddressTheSame(billing));
    }

    @When("I click proceed to checkout from address page")
    public void iClickProceedToCheckoutFromAddressPage() {
        shippingPage = addressPage.goToShippingPageFromAddressPage();
    }

    @Then("I'm taken to the shipping page")
    public void iMTakenToTheShippingPage() {
        Assertions.assertTrue(webDriver.findElement(By.className("page-heading")).getText().contains("SHIPPING"));
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }
}
