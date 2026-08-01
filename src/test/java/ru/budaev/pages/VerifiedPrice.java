package ru.budaev.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class VerifiedPrice {
    private final SelenideElement priceElement = $(".styles-module-scss-module__kWKzya__price");

    public VerifiedPrice verifyPrice(String checkPrice) {
        switchTo().window(2);
        priceElement.shouldHave(text(checkPrice));
        return this;
    }
}