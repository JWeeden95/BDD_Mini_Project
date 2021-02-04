package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddressPage extends Page{

    //http://automationpractice.com/index.php?controller=order&step=1
    List<String> bAddress = new ArrayList<>();
    List<String> sAddress = new ArrayList<>();
    By comments = new By.ByClassName("form-control");

    public AddressPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public boolean isCommentEmpty()
    {
        return webDriver.findElement(comments).getText().equals("") || webDriver.findElement(comments) == null;
    }

    public List<String> getShippingAddress()
    {
        sAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_firstname address_lastname")).getText());
        sAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_address1 address_address2")).getText());
        sAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_city address_state_name address_postcode")).getText());
        sAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_country_name")).getText());
        sAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_phone_mobile")).getText());
        return sAddress;
    }

    public List<String> getBillingAddress()
    {
        bAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_firstname address_lastname")).getText());
        bAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_address1 address_address2")).getText());
        bAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_city address_state_name address_postcode")).getText());
        bAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_country_name")).getText());
        bAddress.add(webDriver.findElement(By.className("address item box")).findElement(By.className("address_phone_mobile")).getText());
        return bAddress;
    }

    public boolean shippingIsBilling()
    {
        String string = webDriver.findElement(By.id("addressesAreEquals")).getText();
        return string.equals("checked");
    }
}
