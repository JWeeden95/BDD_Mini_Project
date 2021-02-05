package com.sparta.jw.pom.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    WebDriver webDriver;

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getPageAsString() {
        return webDriver.getPageSource();
    }

    public void goForward() {
        webDriver.navigate().forward();
    }

    public void goBack() {
        webDriver.navigate().back();
    }
}