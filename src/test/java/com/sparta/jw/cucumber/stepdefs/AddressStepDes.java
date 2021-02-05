package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.AddressPage;
import com.sparta.jw.pom.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
        Assertions.assertTrue(addressPage.isBillingAddressAndMyAddressTheSame());
    }

    @When("I click proceed to checkout from address page")
    public void iClickProceedToCheckoutFromAddressPage() {
        shippingPage = addressPage.goToShippingPageFromAddressPage();
    }

    @Then("I'm taken to the shipping page")
    public void iMTakenToTheShippingPage() {
        Assertions.assertTrue(webDriver.findElement(By.className("page-heading")).getText().contains("SHIPPING"));
    }

    @Given("that I am on the Address page for Change")
    public void thatIAmOnTheAddressPageForChange() {
        homePage = new HomePage(webDriver);
        webDriver.findElement(By.className("logout")).click();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
    }

    @And("My shipping Address is my Billing Address button checked")
    public void myShippingAddressIsMyBillingAddressButtonChecked() {
        Assertions.assertTrue(addressPage.addressIsShipping());
    }

    @When("I change my address")
    public void iChangeMyAddress() {
        addressPage.changeBothAddress();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("My address for both billing and shipping changed to selected")
    public void myAddressForBothBillingAndShippingChangedToSelected() {
        Assertions.assertTrue(addressPage.isBillingAddressAndMyAddressTheSame());
    }

    @Given("that I am on the Address page to change just shipping address")
    public void thatIAmOnTheAddressPageToChangeJustShippingAddress() {
        homePage = new HomePage(webDriver);
        webDriver.findElement(By.className("logout")).click();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
    }

    @And("My shipping Address isn't my billing address")
    public void myShippingAddressIsnTMyBillingAddress() {
        addressPage.switchOffSameAddress();
    }

    @When("I change my shipping address")
    public void iChangeMyShippingAddress() {
        addressPage.changeShippingAddress(1);
    }

    @Then("I will have a different shipping address")
    public void iWillHaveADifferentShippingAddress() {
        Assertions.assertFalse(addressPage.isBillingAddressAndMyAddressTheSame());
    }

    @Given("I am signed in on the address page")
    public void iAmSignedInOnTheAddressPage() {
        homePage = new HomePage(webDriver);
        webDriver.findElement(By.className("logout")).click();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
    }

    @And("My shipping Address is my Billing Address button unchecked")
    public void myShippingAddressIsMyBillingAddressButtonUnchecked() {
        addressPage.switchOffSameAddress();
    }

    @When("I change my billing address")
    public void iChangeMyBillingAddressToAddressTwo() {
        addressPage.changeBillingAddress(1);
    }

    @Then("My billing address doesn't change")
    public void myBillingAddressDoesntChange() {
        Assertions.assertFalse(addressPage.isBillingAddressAndMyAddressTheSame());
    }
}
