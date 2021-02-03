package com.sparta.jw.pom.pages;

import org.openqa.selenium.WebDriver;

public class SignInPage {
    //http://automationpractice.com/index.php?controller=authentication&back=my-account

    private WebDriver webDriver;

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}
