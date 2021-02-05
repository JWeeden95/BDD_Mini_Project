package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomePage extends Page {

    By proceedToCheckoutLink = new By.ByCssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    By continueShopping = new By.ByCssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span");
    By cartDropdown = new By.ByCssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    By proceedToCheckoutLinkAlternative = new By.ByClassName("cart-buttons");
    By signIn = new By.ByClassName("login");

    public HomePage(WebDriver driver) {
        webDriver = driver;
        goToHomePage();
    }

    //not sure if I needed this or not, just added for piece of mind when testing the LetsDoThis class (JF)
    public WebDriver homeDriver()
    {
        return webDriver;
    }

    public void goToHomePage(){
        webDriver.get("http://automationpractice.com/index.php");
    }

    public SignInPage goToSignInPageFromHomePage() {
        webDriver.findElement(signIn).click();
        return new SignInPage(webDriver);
    }

    public void addFirstItemToBasket() {
        Actions action = new Actions(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Selects the first item from the first line of items
        WebElement element = webDriver.findElement(By.className("first-item-of-mobile-line"));
        action.moveToElement(element).perform();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")).click();
    }

    public void clickContinueShopping() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(continueShopping).click();
    }

    public SummaryPage goToSummaryPageFromHomePage() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(proceedToCheckoutLink).click();
        return new SummaryPage(webDriver);
    }

    public SummaryPage goToSummaryPageFromHomePageAlternative() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(cartDropdown)).perform();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.findElement(proceedToCheckoutLinkAlternative).click();
        return new SummaryPage(webDriver);
    }

    public boolean correctCartAmount(WebDriver driver, int itemCount) {
        String total = webDriver.findElement(By.className("shopping_cart")).findElement(By.className("ajax_cart_quantity")).getText();
        return Integer.parseInt(total) == itemCount;
    }

}