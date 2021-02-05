package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BankChequePaymentPageStepDefs {
    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private SummaryPage summaryPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentMethodPage paymentMethodPage;
    private BankChequePaymentPage bankChequePaymentPage;
    private BankChequePaymentConfirmationPage chequePaymentConfirmationPage;

    @Given("I am on the Bank Cheque Payment Page")
    public void iAmOnTheBankChequePaymentPage() {
        signInPage = homePage.goToSignInPageFromHomePage();
        myAccountPage = signInPage.goToMyAccountPageFromSignInPage();
        homePage = myAccountPage.goToHomePageFromMyAccountPage();
        homePage.addFirstItemToBasket();
        summaryPage = homePage.goToSummaryPageFromHomePage();
        addressPage = summaryPage.goToAddressPageFromSummaryPage();
        shippingPage = addressPage.goToShippingPageFromAddressPage();
        shippingPage.clickConfirmCheckbox();
        paymentMethodPage = shippingPage.goToPaymentMethodPageFromShippingPage();
        bankChequePaymentPage = paymentMethodPage.goToBankChequePaymentPageFromPaymentMethodPage();

    }

    @When("I click on confirm my order from Bank Cheque Payment Page")
    public void iClickOnConfirmMyOrderFromBankChequePaymentPage() {
        chequePaymentConfirmationPage = bankChequePaymentPage.goToPaymentConfirmationPageFromChequePaymentPage();
    }

    @Then("The Cheque Payment Confirmation Page Appears")
    public void theBankChequePaymentConfirmationPageAppears() {
        Assertions.assertTrue(chequePaymentConfirmationPage.getPageAsString().contains("Your order on My Store is complete."));
    }

    @When("I click on Other payment methods on Bank Cheque Payment Page")
    public void iClickOnOtherPaymentMethodsOnBankChequePaymentPage() {
        paymentMethodPage = bankChequePaymentPage.goBackToPaymentConfirmationPageFromBankChequePaymentPage();
    }

    @Then("The user is sent back to the Payment Methods Page from Bank Cheque Payment Page")
    public void theUserIsSentBackToThePaymentMethodsPageFromBankChequePaymentPage() {
        Assertions.assertTrue(paymentMethodPage.getNavigationPageText().contains("Your payment method"));
    }

    @When("I click on the Home Page Icon on the Bank Cheque Payment Method Page")
    public void iClickOnTheHomePageIconOnTheBankChequePaymentMethodPage() {
        homePage = bankChequePaymentPage.goToHomePageFromBankChequePaymentPage();
    }

    @Then("The user is sent back to the Home Page from the Bank Cheque Payment Method Page")
    public void theUserIsSentBackToTheHomePageFromTheBankChequePaymentMethodPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php", homePage.getUrl());
    }
}
