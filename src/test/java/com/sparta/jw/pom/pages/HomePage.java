package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private static WebDriver webDriver;
    By proceedToCheckoutLink = new By.ByClassName("btn btn-default button button-medium");

    public HomePage(WebDriver driver) {
        webDriver = driver;
    }

    public void addFirstItemToBasket() {
        Actions action = new Actions(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Selects the first item from the first line of items
        WebElement element = webDriver.findElement(By.className("first-item-of-mobile-line"));
        action.moveToElement(element).perform();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")).click();
        webDriver.findElement(By.className("button-container")).click();
    }

    public SummaryPage clickProceedToCheckout() {
        webDriver.findElement(proceedToCheckoutLink).click();
        return new SummaryPage(webDriver);
    }

    public boolean correctCartAmount(WebDriver driver, int itemCount) {
        String total = webDriver.findElement(By.className("shopping_cart")).findElement(By.className("ajax_cart_quantity")).getText();
        return Integer.parseInt(total) == itemCount;
    }
}


