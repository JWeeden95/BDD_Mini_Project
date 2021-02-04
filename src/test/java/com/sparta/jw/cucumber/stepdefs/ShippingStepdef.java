package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShippingStepdef {
    static WebDriver webDriver;
    HomePage homePage;
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    SummaryPage summaryPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentMethodPage paymentMethodPage;

    @Given("that I am on the shipping page")
    public void thatIAmOnTheShippingPage() {
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
        shippingPage = addressPage.goToShippingPageFromAddressPage();
        Assertions.assertTrue(shippingPage.getPageAsString().contains("Choose a shipping option for this address:"));
    }

    @And("I have ticked the ‘agree to terms of service’ box")
    public void iHaveTickedTheAgreeToTermsOfServiceBox() {
        shippingPage.clickConfirmCheckbox();
    }

    @When("I click proceed to checkout from shipping page")
    public void iClickProceedToCheckoutFromShippingPage() {
        paymentMethodPage = shippingPage.goToPaymentMethodPageFromShippingPage();
    }

    @Then("the Payment page appears")
    public void thePaymentPageAppears() {
        Assertions.assertTrue(shippingPage.getPageAsString().contains("PLEASE CHOOSE YOUR PAYMENT METHOD"));
    }

}
