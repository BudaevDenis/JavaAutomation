package ru.budaev.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {
    private final SelenideElement payButton = $(byText("Бегу оплачивать"));

    public VerifiedPrice clickPayButton() {
            payButton.click();
            return new VerifiedPrice();
}

}
