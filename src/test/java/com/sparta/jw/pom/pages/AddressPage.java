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

    public boolean isBillingAddressAndMyAddressTheSame(List<String> myAdd)
    {
        boolean isSame = true;
        getBillingAddress();
        for(int i = 0; i < bAddress.size(); i++)
        {
            if(!myAdd.get(i).equals(bAddress.get(i)))
            {
                isSame = false;
            }
        }
        return isSame;
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

    public void changeBothAddressIfTheyArentDifferent()
    {
        webDriver.findElement(By.id("uniform-id_address_delivery")).click();
        webDriver.findElement(By.cssSelector("#id_address_delivery > option:nth-child(2)")).click();
    }

    public void changeShippingAddress()
    {
        webDriver.findElement(By.id("uniform-id_address_invoice")).click();
        webDriver.findElement(By.cssSelector("#id_address_delivery > option:nth-child(2)")).click();
    }

    public void changeBillingAddress()
    {
        webDriver.findElement(By.className("selector")).click();
        webDriver.findElement(By.cssSelector("#id_address_delivery > option:nth-child(2)")).click();
    }

    public boolean addressIsShipping()
    {
        return webDriver.findElement(clickEqualAddress).isSelected();
    }

}
