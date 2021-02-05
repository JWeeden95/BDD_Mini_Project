package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentMethodPageStepDefs {
    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private SummaryPage summaryPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentMethodPage paymentMethodPage;
    private BankWirePaymentPage bankWirePaymentPage;
    private BankChequePaymentPage bankChequePaymentPage;

    @Given("I am on the Payment Method Page")
    public void iAmOnThePaymentMethodPage() {
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

    }

    @When("I click pay by bank wire")
    public void iClickPayByBankWire() {
        bankWirePaymentPage = paymentMethodPage.goToBankWirePaymentPageFromPaymentMethodPage();
    }

    @Then("The bank wire payment page appears")
    public void theBankWirePaymentPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment", bankWirePaymentPage.getUrl());
    }

    @When("I click on continue shopping on the Payment Method Page")
    public void iClickOnContinueShoppingOnThePaymentMethodPage() {
        shippingPage = paymentMethodPage.clickContinueShoppingFromPaymentMethodPage();
    }

    @When("I click on Shipping Page on the Payment Method Page")
    public void iClickOnShippingPageOnThePaymentMethodPage() {
        shippingPage = paymentMethodPage.goToShippingPageFromPaymentMethodPage();
    }

    @Then("The user is sent back to the Shipping Page From the Payment Method Page")
    public void theUserIsSentBackToTheShippingPage() {
        Assertions.assertTrue(shippingPage.getPageAsString().contains("Choose a shipping option for this address:"));
    }

    @When("I click on Address Page on the Payment Method Page")
    public void iClickOnAddressPageOnThePaymentMethodPage() {
        addressPage = paymentMethodPage.goToAddressPageFromPaymentMethodPage();
    }

    @Then("The user is sent back to the Address Page From the Payment Method Page")
    public void theUserIsSentBackToTheAddressPage() {
        Assertions.assertTrue(addressPage.getPageAsString().contains("Choose a delivery address:"));
    }

    @When("I click on Summary Page on the Payment Method Page")
    public void iClickOnSummaryPageOnThePaymentMethodPage() {
        summaryPage = paymentMethodPage.goToSummaryPageFromPaymentMethodPage();
    }

    @Then("The user is sent back to the Summary Page From the Payment Method Page")
    public void theUserIsSentBackToTheSummaryPageFromThePaymentMethodPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order", summaryPage.getUrl());
    }

    @When("I click on the Home Page Icon on the Payment Method Page")
    public void iClickOnTheHomePageIconOnThePaymentMethodPage() {
        homePage = paymentMethodPage.goToHomePageFromPaymentMethodPage();
    }

    @Then("The user is sent back to the Home Page from the Payment Method Page")
    public void theUserIsSentBackToTheHomePageFromThePaymentMethodPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php", homePage.getUrl());
    }

    @When("I click pay by check")
    public void iClickPayByCheck() {
        bankChequePaymentPage = paymentMethodPage.goToBankChequePaymentPageFromPaymentMethodPage();
    }

    @Then("The Bank Cheque Payment Page appears")
    public void theBankChequePaymentPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?fc=module&module=cheque&controller=payment", bankChequePaymentPage.getUrl());
    }
}
