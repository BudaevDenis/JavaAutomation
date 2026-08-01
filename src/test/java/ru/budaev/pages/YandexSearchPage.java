package ru.budaev.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexSearchPage {
    private final SelenideElement searchInput = $("#text");
    private final SelenideElement submitButton = $("[type=submit]");

    public YandexSearchPage openYandexSearch() {
        open("https://ya.ru/");

        return this;
    }

    public YandexSearchPage search(String query) {
        searchInput.setValue(query); //яндекс поиск

        return this;
    }

    public YandexSearchResultPage submit() {
        submitButton.click();


        return new YandexSearchResultPage();
    }
}
