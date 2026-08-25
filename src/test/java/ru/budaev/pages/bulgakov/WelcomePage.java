package ru.budaev.pages.bulgakov;

import com.codeborne.selenide.SelenideElement;
import ru.budaev.pages.BasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage extends BasePage {
    // В меню ищем по якорю, а не по "последнему пункту": пункт добавят - тест сломается
    private final SelenideElement priceMenuButton = $(".t-menu__list a[href='#cost']"),
            wantToQaButton = $(byText("Хочу вкатиться в QA")),
            runToPayButton = $(byText("Бегу оплачивать"));

    public WelcomePage openStudySection() {
        priceMenuButton.click();

        return this;
    }

    public WelcomePage clickWantToQa() {
        wantToQaButton.click();

        return this;
    }

    // Оплата открывается новой вкладкой, её Page Object даст switchToWindow
    public WelcomePage clickRunToPay() {
        runToPayButton.click();

        return this;
    }
}
