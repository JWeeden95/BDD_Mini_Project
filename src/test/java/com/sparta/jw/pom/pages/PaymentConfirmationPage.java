package com.sparta.jw.pom.pages;

import org.openqa.selenium.WebDriver;

public class PaymentConfirmationPage {

    //http://automationpractice.com/index.php?controller=order-confirmation&id_cart=2681509&id_module=3&id_order=283131&key=5a77c54c09b06b9c65c61b69814e8bbd

    WebDriver webDriver;

    //Added so the page could be created using a driver (JF)
    public PaymentConfirmationPage(WebDriver driver)
    {
        this.webDriver = driver;
    }
}
