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
    private static WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private SummaryPage summaryPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentMethodPage paymentMethodPage;

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
    }


    @When("I click proceed to checkout from shipping page")
    public void iClickProceedToCheckoutFromShippingPage() {
        paymentMethodPage = shippingPage.goToPaymentMethodPageFromShippingPage();
    }

    @Then("the Payment page appears")
    public void thePaymentPageAppears() {
        Assertions.assertTrue(paymentMethodPage.getPageAsString().contains("Pay by bank wire"));
    }

    @When("I click the agree to terms of service box")
    public void iClickTheAgreeToTermsOfServiceBox() {
        shippingPage.clickConfirmCheckbox();
    }

    @Then("the agree to terms of service box should be ticked")
    public void theAgreeToTermsOfServiceBoxShouldBeTicked() {
        Assertions.assertTrue(shippingPage.checkConfirmationCheckboxHasBeenTicked());
    }
}
