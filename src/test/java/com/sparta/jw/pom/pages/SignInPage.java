package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Page{
    //http://automationpractice.com/index.php?controller=authentication&back=my-account

    By email = new By.ById("email");
    By password = new By.ById("passwd");
    By orderStepBar = new By.ById("order_step");

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean hasOrderStepBar(){
        return webDriver.findElement(orderStepBar).isDisplayed();
    }

    public MyAccountPage goToMyAccountPageFromSignInPage(){
        webDriver.findElement(email).sendKeys("greg.spratt@icloud.com");
        webDriver.findElement(password).sendKeys("honsoc-6Qekhi-hijqax", Keys.ENTER);
        return new MyAccountPage(webDriver);
    }

    public AuthenticationPage goToAuthenticationPageBadEmail(){
        webDriver.findElement(email).sendKeys("greg");
        webDriver.findElement(password).sendKeys("honsoc-6Qekhi-hijqax", Keys.ENTER);
        return new AuthenticationPage(webDriver);
    }

    public AuthenticationPage goToAuthenticationPageBadPassword(){
        webDriver.findElement(email).sendKeys("greg.spratt@icloud.com");
        webDriver.findElement(password).sendKeys("bad", Keys.ENTER);
        return new AuthenticationPage(webDriver);
    }

    public AuthenticationPage goToAuthenticationPageBadEmailAndPassword(){
        webDriver.findElement(email).sendKeys("greg");
        webDriver.findElement(password).sendKeys("bad", Keys.ENTER);
        return new AuthenticationPage(webDriver);
    }
}
