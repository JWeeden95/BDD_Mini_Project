package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShippingStepdef {
    static WebDriver webDriver = new ChromeDriver();
    HomePage homePage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    SummaryPage summaryPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentMethodPage paymentMethodPage;

    @Given("that I am on the shipping page and checkbox is checked")
    public void thatIAmOnTheShippingPageAndCheckboxIsChecked() {
        homePage = new HomePage(webDriver);
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
        shippingPage = addressPage.goToShippingPageFromAddressPage();
        shippingPage.clickConfirmCheckbox();
    }

    @When("I click proceed to checkout from shipping page")
    public void iClickProceedToCheckoutFromShippingPage() {
        paymentMethodPage = shippingPage.goToPaymentMethodPageFromShippingPage();
    }

    @Then("confirm I am on the payment confirmation page")
    public void confirmIAmOnThePaymentConfirmationPage() {
        Assertions.assertTrue(paymentMethodPage.getPageAsString().contains("Pay by bank wire"));
    }


    @Given("that I am on the shipping page")
    public void thatIAmOnTheShippingPage() {
        homePage = new HomePage(webDriver);
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
        shippingPage = addressPage.goToShippingPageFromAddressPage();
    }

    @When("I click the agree to terms of service box")
    public void iClickTheAgreeToTermsOfServiceBox() {
        shippingPage.clickConfirmCheckbox();
    }

    @Then("the agree to terms of service box should be ticked")
    public void theAgreeToTermsOfServiceBoxShouldBeTicked() {
        Assertions.assertTrue(shippingPage.checkConfirmationCheckboxHasBeenTicked());
//        webDriver.close();
    }


    @Given("that I am still on the shipping page")
    public void thatIAmStillOnTheShippingPage() {
        homePage = new HomePage(webDriver);
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
        shippingPage = addressPage.goToShippingPageFromAddressPage();
    }

    @When("I click the Continue shopping button")
    public void iClickTheContinueShoppingButton() {
        addressPage = shippingPage.goToAddressPageFromShippingPage();
    }

    @Then("I go to the address page")
    public void iGoToTheAddressPage() {
        Assertions.assertTrue(addressPage.getPageAsString().contains("Choose a delivery address:"));
    }
}
