package com.sparta.jw.cucumber.stepdefs;

import com.sparta.jw.pom.pages.AddressPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addressI15SD {

    private static WebDriver webDriver;
    private static AddressPage addressPage;
    By comments = new By.ByClassName("form-control");

    @Before
    public void setUp()
    {
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }

    @Given("that I am on {string} page")
    public void thatIAmOnPage(String arg0) {
        webDriver.get(arg0);
        addressPage = new AddressPage(webDriver);
    }

    @And("I have left no comment in the comment box")
    public void iHaveLeftNoCommentInTheCommentBox() {
        webDriver.findElement(comments).sendKeys("Hello World!");
        Assertions.assertTrue(addressPage.isCommentEmpty());
    }

    @And("my billing information is correct")
    public void myBillingInformationIsCorrect() {
    }

    @When("I click proceed to checkout from address page")
    public void iClickProceedToCheckoutFromAddressPage() {
    }

    @Then("the next page is the shipping page, which has the url {string}")
    public void theNextPageIsTheShippingPageWhichHasTheUrl(String arg0) {
        Assertions.assertEquals(arg0, "http://automationpractice.com/index.php?controller=order");
    }
}
