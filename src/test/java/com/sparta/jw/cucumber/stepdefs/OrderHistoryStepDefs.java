package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderHistoryStepDefs {
    private WebDriver webDriver = new ChromeDriver();
    private HomePage homePage = new HomePage(webDriver);
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private SummaryPage summaryPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentMethodPage paymentMethodPage;
    private BankChequePaymentPage bankChequePaymentPage;
    private BankChequePaymentConfirmationPage bankChequePaymentConfirmationPage;
    private OrderHistoryPage orderHistoryPage;
    private String orderReference;

    @Given("I am on the Bank Cheque Confirmation Page")
    public void iAmOnTheBankChequeConfirmationPage() {
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
        bankChequePaymentConfirmationPage = bankChequePaymentPage.goToPaymentConfirmationPageFromChequePaymentPage();


    }

    @And("I have the order reference")
    public void iHaveTheOrderReference() {
        orderReference = bankChequePaymentConfirmationPage.orderReferenceString();
    }

    @When("I click go to Order History Page")
    public void iClickGoToOrderHistoryPage() {
        orderHistoryPage = bankChequePaymentConfirmationPage.goToOrderHistoryPageFromChequePaymentConfirmationPage();
    }

    @Then("The order reference should be there")
    public void theOrderReferenceShouldBeThere() {
        Assertions.assertTrue(orderHistoryPage.getPageAsString().contains(orderReference));
    }
}
