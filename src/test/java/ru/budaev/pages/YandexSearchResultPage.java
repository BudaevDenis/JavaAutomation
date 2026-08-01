package ru.budaev.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class YandexSearchResultPage {
    private final SelenideElement closeWindow = $(".DistributionButtonClose");

    public YandexSearchResultPage closeDefaultBrowserSelectWindow() {
        closeWindow.click();

        return this;
    }

    public WelcomePage openLink(String webSiteName) {
        $(byText(webSiteName)).click();

        return new  WelcomePage();
    }
}
