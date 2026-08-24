package ru.budaev.pages.qastudio;

import com.codeborne.selenide.SelenideElement;
import ru.budaev.pages.BasePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TariffPaymentPage extends BasePage {
    private final SelenideElement emailInput = $("#email"),
            payButton = $("#paySubmit");

    public TariffPaymentPage selectTariff(String tariffName) {
        $(byText(tariffName)).click();

        return this;
    }

    public TariffPaymentPage fillEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public TariffPaymentPage checkEmail(String expectedEmail) {
        emailInput.shouldHave(value(expectedEmail));

        return this;
    }

    public TariffPaymentPage checkPayButtonIsReady() {
        payButton.shouldBe(enabled);

        return this;
    }
}
