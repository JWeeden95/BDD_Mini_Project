package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    WebDriver webDriver;
    By shoppingCartLink = new By.ByCssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    By cartDropdown = new By.ByCssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    By dropDownCheckoutLink = new By.ByClassName("cart-buttons");

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getPageAsString() {
        return webDriver.getPageSource();
    }

    public void goForward() {
        webDriver.navigate().forward();
    }

    public void goBack() {
        webDriver.navigate().back();
    }

    public SummaryPage goToSummaryPageByClickingShoppingCart() {
        webDriver.findElement(shoppingCartLink).click();
        return new SummaryPage(webDriver);
    }

    public SummaryPage goToSummaryPageByClickingCartDropdown() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(cartDropdown)).perform();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.findElement(dropDownCheckoutLink).click();
        return new SummaryPage(webDriver);
    }
}