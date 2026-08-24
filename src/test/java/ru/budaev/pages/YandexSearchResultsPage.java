package ru.budaev.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexSearchResultsPage extends BasePage {
    // Баннеры появляются не всегда, ждём их отдельно от общего таймаута
    private static final Duration BANNER_TIMEOUT = Duration.ofSeconds(2);

    private final SelenideElement defaultBrowserBanner = $("[aria-label='Нет, спасибо']"),
            distributionBanner = $(".DistributionButtonClose");

    // isDisplayed() не ждёт появления элемента, поэтому даём условию явный таймаут
    public YandexSearchResultsPage closeDefaultBrowserBannerIfAppeared() {
        if (defaultBrowserBanner.is(visible, BANNER_TIMEOUT)) {
            defaultBrowserBanner.click();
        }

        return this;
    }

    // Обычный клик по этому баннеру срабатывает не всегда - кликаем через JS
    public YandexSearchResultsPage closeDistributionBannerIfAppeared() {
        if (distributionBanner.is(visible, BANNER_TIMEOUT)) {
            distributionBanner.click(usingJavaScript());
        }

        return this;
    }

    /**
     * Клик по ссылке - действие выдачи, поэтому возвращаем её же:
     * сайт открывается новой вкладкой, и его Page Object даст switchToWindow.
     */
    public YandexSearchResultsPage openLink(String webSiteName) {
        // Ссылку берём по адресу: тот же текст лежит в скрытом блоке нейро-ответа
        $$("a[href*='" + webSiteName + "']").filterBy(visible)
                .first()
                .click();

        return this;
    }
}
