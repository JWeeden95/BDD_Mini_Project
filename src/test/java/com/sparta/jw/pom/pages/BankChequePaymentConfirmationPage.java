package com.sparta.jw.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankChequePaymentConfirmationPage extends Page {

    public BankChequePaymentConfirmationPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public OrderHistoryPage goToOrderHistoryPageFromChequePaymentConfirmationPage(){
        webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a")).click();
        return new OrderHistoryPage(webDriver);
    }

    public String orderReferenceString(){
        Pattern pattern = Pattern.compile("Do not forget to include your order reference [A-Z]{9}");
        Matcher matcher = pattern.matcher(webDriver.getPageSource());
        String referenceCode;
        if (matcher.find()){
            referenceCode = matcher.group(0);
            return referenceCode.substring(referenceCode.length()-9);
        }
        return null;
    }

}
