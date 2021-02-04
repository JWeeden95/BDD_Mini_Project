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
        String string = webDriver.findElement(By.cssSelector("#address_delivery")).getText();
        sAddress.addAll(Arrays.asList(string.split("([\n]|[,])")));
        sAddress.remove(0);
        sAddress.remove(6);
        return sAddress;
    }

    public List<String> getBillingAddress()
    {
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

    public boolean IsBillingAddressAndMyAddressTheSame(List<String> myAdd)
    {
        boolean isSame = false;
        getBillingAddress();
        for(int i = 0; i < bAddress.size(); i++)
        {
            if(myAdd.get(i).equals(bAddress.get(i)))
            {
                isSame = true;
            }
        }
        return isSame;
    }

    public ShippingPage goToShippingPageFromAddressPage()
    {
        webDriver.findElement(By.name("processAddress")).click();
        return new ShippingPage(webDriver);
    }
}
