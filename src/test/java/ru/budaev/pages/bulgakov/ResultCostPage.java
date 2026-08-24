package ru.budaev.pages.bulgakov;

import com.codeborne.selenide.SelenideElement;
import ru.budaev.pages.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultCostPage extends BasePage {
    private final SelenideElement priceAmount = $(".ant-flex h3");

    public ResultCostPage checkPriceAmount(String expectedPrice) {
        priceAmount.shouldHave(text(expectedPrice));

        return this;
    }
}
