package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
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

    @Given("that I am on the shipping page")
    public void thatIAmOnTheShippingPage() {
        homePage = new HomePage(webDriver);
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
        shippingPage = addressPage.goToShippingPageFromAddressPage();
    }

    @And("I have clicked the agree to terms of service box")
    public void iHaveClickedTheAgreeToTermsOfServiceBox() {
        shippingPage.clickConfirmCheckbox();
    }

    @When("I click proceed to checkout from shipping page")
    public void iClickProceedToCheckoutFromShippingPage() {
        paymentMethodPage = shippingPage.goToPaymentMethodPageFromShippingPage();
    }

    @Then("confirm I am on the payment confirmation page")
    public void confirmIAmOnThePaymentConfirmationPage() {
        Assertions.assertTrue(paymentMethodPage.getPageAsString().contains("Pay by bank wire"));
        webDriver.close();
    }



    @When("I click the agree to terms of service box")
    public void iClickTheAgreeToTermsOfServiceBox() {
        shippingPage.clickConfirmCheckbox();
    }

    @Then("the agree to terms of service box should be ticked")
    public void theAgreeToTermsOfServiceBoxShouldBeTicked() {
        Assertions.assertTrue(shippingPage.checkConfirmationCheckboxHasBeenTicked());
        webDriver.close();
    }


}
