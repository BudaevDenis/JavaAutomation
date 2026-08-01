package ru.budaev.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class WelcomePage {
    public final ElementsCollection menuItems = $$(".t-menu__list li");
    public final SelenideElement clickButtonRunPay = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");

    public PaymentPage clickPrice(){
        sleep(3000);
        switchTo().window(1);
        menuItems.last().click();
        clickButtonRunPay.click();

        return new PaymentPage();

    }

}
