package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AddressPage extends Page{

    private static final Properties properties = new Properties();
    private static final String PROPERTIES_PATH = "src/test/resources/userDetails.properties";
    By clickEqualAddress = new By.ById("addressesAreEquals");
    List<String> bAddress;
    List<String> sAddress;
    List<String> actualBillingAddress = new ArrayList<>();
    List<String> addressTwo = new ArrayList<>();
    By comments = new By.ByClassName("form-control");

    public AddressPage(WebDriver webDriver)
    {
        createProperties();
        setActualBillingAddress();
        setAddressTwo();
        this.webDriver = webDriver;
    }

    public boolean isCommentEmpty()
    {
        return webDriver.findElement(comments).getText().equals("") || webDriver.findElement(comments) == null;
    }

    public boolean isBillingAddressAndMyAddressTheSame()
    {
        getBillingAddress();
        getShippingAddress();
        return bAddress.equals(sAddress);
    }

    public ShippingPage goToShippingPageFromAddressPage()
    {
        webDriver.findElement(By.name("processAddress")).click();
        return new ShippingPage(webDriver);
    }

    public void switchOffSameAddress()
    {
        webDriver.findElement(clickEqualAddress).click();
    }

    public void changeBothAddress()
    {
        webDriver.findElement(By.id("uniform-id_address_delivery")).click();
        webDriver.findElement(By.cssSelector("#id_address_delivery > option:nth-child(2)")).click();
    }

    public void changeShippingAddress(int address)
    {
        webDriver.findElement(By.id("id_address_delivery")).click();
        switch(address)
        {
            case 1:
                webDriver.findElement(By.cssSelector("#id_address_delivery > option:nth-child(1)")).click();
                break;
            case 2:
                webDriver.findElement(By.cssSelector("#id_address_delivery > option:nth-child(2)")).click();
                break;
        }
    }

    public void changeBillingAddress(int address)
    {
        webDriver.findElement(By.id("uniform-id_address_invoice")).click();
        switch(address)
        {
            case 1:
                webDriver.findElement(By.cssSelector("#id_address_invoice > option:nth-child(1)")).click();
                break;
            case 2:
                webDriver.findElement(By.cssSelector("#id_address_invoice > option:nth-child(2)")).click();
                break;
        }
    }

    public boolean addressIsShipping()
    {
        return webDriver.findElement(clickEqualAddress).isSelected();
    }

    private static void createProperties() {
        try {
            properties.load(new FileReader(PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo() {
        String address2 = properties.getProperty("address");
        addressTwo.addAll(Arrays.asList(address2.split(",")));
    }

    public List<String> getActualBillingAddress() {
        return actualBillingAddress;
    }

    public List<String> getShippingAddress()
    {
        sAddress = new ArrayList<>();
        String string = webDriver.findElement(By.cssSelector("#address_delivery")).getText();
        sAddress.addAll(Arrays.asList(string.split("([\n]|[,])")));
        sAddress.remove(0);
        sAddress.remove(6);
        return sAddress;
    }

    public List<String> getBillingAddress()
    {
        bAddress = new ArrayList<>();
        String string = webDriver.findElement(By.cssSelector("#address_invoice")).getText();
        bAddress.addAll(Arrays.asList(string.split("([\n]|[,])")));
        bAddress.remove(0);
        bAddress.remove(6);
        return bAddress;
    }

    public void setActualBillingAddress()
    {
        String address = properties.getProperty("address");
        actualBillingAddress.addAll(Arrays.asList(address.split(",")));
    }


}
