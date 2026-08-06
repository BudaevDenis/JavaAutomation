package ru.budaev.pagesQaStudio;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.budaev.pages.PaymentPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class JuniorTariffSelection {

    private final SelenideElement clickButtonRunPay = $x("/html/body/main/section[20]/div[1]/div/div[2]/div/table/thead/tr/th[2]/div/div[3]/div/a");

    public JuniorTariffSelection submitSignUp(String clickButtonCourse){
        $(byText(clickButtonCourse)).shouldBe(visible).click();

        return this;
    }

    public JuniorTariffSelection submitPaymentPage(){
        clickButtonRunPay.click();
        switchTo().window(2);

        return this;
    }

    public PaymentTariff clickPayTariffJunior(String selectTariff){
        $(byText(selectTariff)).shouldBe(visible).click();

        return new PaymentTariff();
    }
}




