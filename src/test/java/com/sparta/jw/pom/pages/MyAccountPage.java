package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Page{

    By homeIcon = new By.ByClassName("icon-home");

    public MyAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage goToHomePageFromMyAccountPage(){
        webDriver.findElement(homeIcon).click();
        return new HomePage(webDriver);
    }
}
