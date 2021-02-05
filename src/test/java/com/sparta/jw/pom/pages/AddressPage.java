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

    //http://automationpractice.com/index.php?controller=order&step=1

    private static final Properties properties = new Properties();
    private static final String PROPERTIES_PATH = "src/test/resources/userDetails.properties";
    By clickEqualAddress = new By.ById("addressesAreEquals");
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

    public void makeAddressNotShipping()
    {
        webDriver.findElement(clickEqualAddress).click();
    }

    public void changeBothAddressIfTheyArentDifferent()
    {
        Actions actions = new Actions(webDriver);
        webDriver.findElement(By.className("selector")).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("#id_address_delivery > option:nth-child(2)")).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector("#id_address_delivery > option:nth-child(1)")).click();
    }
}
