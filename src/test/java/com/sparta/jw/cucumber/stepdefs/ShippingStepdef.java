package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.BankWirePaymentPage;
import com.sparta.jw.pom.pages.PaymentConfirmationPage;
import com.sparta.jw.pom.pages.PaymentMethodPage;
import com.sparta.jw.pom.pages.ShippingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShippingStepdef {
    private ShippingPage shippingPage;
    private PaymentMethodPage paymentMethodPage;

    @Given("that I am on the shipping page")
    public void thatIAmOnTheShippingPage(WebDriver webDriver) {
        shippingPage = new ShippingPage(webDriver);
    }

    @And("I have ticked the ‘agree to terms of service’ box")
    public void iHaveTickedTheAgreeToTermsOfServiceBox() {
        Assertions.assertTrue(shippingPage.clickConfirmCheckbox());
    }

    @When("I click proceed to checkout from shipping page")
    public void iClickProceedToCheckoutFromShippingPage() {
        paymentMethodPage = shippingPage.clickGoToPaymentMethodPage();
    }

    //This one needs to be replaced by the above to prevent duplicate error
    @When("I click proceed to checkout")
    public void iClickProceedToCheckout() {
        paymentMethodPage = shippingPage.clickGoToPaymentMethodPage();
    }

    @Then("the Payment page appears")
    public void thePaymentPageAppears() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=order&multi-shipping=", paymentMethodPage.getUrl());
    }

}
