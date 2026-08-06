package ru.budaev.pagesQaStudio;

import com.codeborne.selenide.SelenideElement;
import ru.budaev.pages.YandexSearchPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
    private SelenideElement findInput =  $("#text");
    private SelenideElement submitFindButton =  $("[type=submit]");

     public SearchPage searchQaStudio(String query) {
        findInput.setValue(query);

         return this;

     }

    public SearchResultPage submitButton() {
        submitFindButton.click();

        return new SearchResultPage();

    }


    }