package ru.budaev.pages.qastudio;

import com.codeborne.selenide.SelenideElement;
import ru.budaev.pages.BasePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CoursesPage extends BasePage {
    private final SelenideElement signUpButton = $(byText("Записаться на курс"));

    /**
     * Тариф приходит из теста, поэтому метод, а не поле.
     * Карточку находим по названию тарифа и от него поднимаемся к самой карточке,
     * а кнопку берём уже внутри неё - так клик гарантированно попадает в нужную колонку.
     */
    private SelenideElement payButtonOfTariff(String tariffName) {
        return $$(".format-card__name").findBy(exactText(tariffName))
                .ancestor(".format-card")
                .$(".format-card__button");
    }

    public CoursesPage openSignUpSection() {
        signUpButton.click();

        return this;
    }

    // Оплата открывается новой вкладкой, её Page Object даст switchToWindow
    public CoursesPage clickPayForTariff(String tariffName) {
        payButtonOfTariff(tariffName).click();

        return this;
    }
}
