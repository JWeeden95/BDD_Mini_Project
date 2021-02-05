package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderConfirmationStepdefs {

    private BankWirePaymentPage bankWirePaymentPage;
    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private SummaryPage summaryPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentMethodPage paymentMethodPage;
    private PaymentConfirmationPage paymentConfirmationPage;

    @Given("that I am on the bank wire page")
    public void thatIAmOnTheBankWirePage() {
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
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

    @When("I click other payment methods")
    public void iClickOtherPaymentMethods() {
        paymentMethodPage = bankWirePaymentPage.goBackToPaymentMethodPageFromBankWirePaymentPage();
    }

    @Then("payment method page appears when coming from bank wire payment page")
    public void paymentMethodPageAppearsWhenComingFromBankWirePaymentPage() {
        Assertions.assertTrue(shippingPage.getPageAsString().contains("PLEASE CHOOSE YOUR PAYMENT METHOD"));
        webDriver.close();
    }


}
