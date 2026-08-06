package ru.budaev.pagesQaStudio;

import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.$;

public class PaymentTariff {
    private SelenideElement enterEmail = $("#email");
    private SelenideElement submitPay =  $("#paySubmit");

    public PaymentTariff inputEmail(String email) {

        enterEmail.setValue(email);
        $("#paySubmit").scrollIntoView(false);

        return this;
    }

    public PaymentTariff submitPay() {

        submitPay.click();

        return this;
    }

}
