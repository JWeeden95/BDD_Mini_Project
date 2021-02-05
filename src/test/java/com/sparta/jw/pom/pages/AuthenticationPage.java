package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends Page {

    By homeIcon = new By.ByClassName("icon-home");

    public AuthenticationPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public HomePage goToHomePageFromAuthenticationPage(){
        webDriver.findElement(homeIcon).click();
        return new HomePage(webDriver);
    }

}
