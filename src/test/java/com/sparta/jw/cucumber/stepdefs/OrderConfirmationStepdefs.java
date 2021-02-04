package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderConfirmationStepdefs {

    private BankWirePaymentPage bankWirePaymentPage;
    WebDriver webDriver = new ChromeDriver();
    HomePage homePage = new HomePage(webDriver);
    SignInPage signInPage;
    MyAccountPage myAccountPage;
    SummaryPage summaryPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentMethodPage paymentMethodPage;

    @Given("that I am on the bank wire page")
    public void thatIAmOnTheBankWirePage() {
        homePage.goToHomePage();
        signInPage = homePage.goToSignInPage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
        shippingPage = addressPage.goToShippingPageFromAdressPage();
        shippingPage.clickConfirmCheckbox();
        paymentMethodPage = shippingPage.goToPaymentMethodPage();
        bankWirePaymentPage = paymentMethodPage.goToPayByBankWire();
    }

    @When("I click confirm order")
    public void iClickConfirmOrder() {
        bankWirePaymentPage.goToPaymentConfirmationPage();
    }

    @Then("the order confirmation page appears")
    public void theOrderConfirmationPageAppears() {
    }

}
