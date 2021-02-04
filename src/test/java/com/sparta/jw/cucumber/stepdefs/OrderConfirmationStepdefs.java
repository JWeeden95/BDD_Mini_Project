package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderConfirmationStepdefs {

    BankWirePaymentPage bankWirePaymentPage;
    WebDriver webDriver = new ChromeDriver();
    HomePage homePage = new HomePage(webDriver);
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    SummaryPage summaryPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentMethodPage paymentMethodPage;
    PaymentConfirmationPage paymentConfirmationPage;

    @Given("that I am on the bank wire page")
    public void thatIAmOnTheBankWirePage() {
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
        shippingPage = addressPage.goToShippingPageFromAddressPage();
        shippingPage.clickConfirmCheckbox();
        paymentMethodPage = shippingPage.goToPaymentMethodPageFromShippingPage();
        bankWirePaymentPage = paymentMethodPage.goToBankWirePaymentPageFromPaymentMethodPage();
    }

    @When("I click confirm order")
    public void iClickConfirmOrder() {
        paymentConfirmationPage = bankWirePaymentPage.goToPaymentConfirmationPageFromBankWirePaymentPage();
    }

    @Then("the order confirmation page appears")
    public void theOrderConfirmationPageAppears() {
        Assertions.assertTrue(paymentConfirmationPage.getPageAsString().contains("Your order on My Store is complete."));
    }

}
