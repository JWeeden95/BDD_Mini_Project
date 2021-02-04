package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class AddressPage extends Page{

    //http://automationpractice.com/index.php?controller=order&step=1

    private static final Properties properties = new Properties();
    private static final String PROPERTIES_PATH = "src/test/resources/userDetails.properties";
    List<String> bAddress = new ArrayList<>();
    List<String> sAddress = new ArrayList<>();
    List<String> actualBillingAddress = new ArrayList<>();
    By comments = new By.ByClassName("form-control");

    public List<String> getActualBillingAddress() {
        return actualBillingAddress;
    }

    public AddressPage(WebDriver webDriver)
    {
        createProperties();
        setActualBillingAddress();
        this.webDriver = webDriver;
    }

    private static void createProperties() {
        try {
            properties.load(new FileReader(PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void setActualBillingAddress()
    {
        String address = properties.getProperty("address");
        actualBillingAddress.addAll(Arrays.asList(address.split(",")));
    }

    public boolean shippingIsBilling()
    {
        String string = webDriver.findElement(By.id("addressesAreEquals")).getText();
        return string.equals("checked");
    }

    public ShippingPage goToShippingPageFromAddressPage()
    {
        webDriver.findElement(By.name("processAddress")).click();
        return new ShippingPage(webDriver);
    }
}
