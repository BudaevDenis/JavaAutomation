package ru.budaev.pagesQaStudio;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.files.DownloadActions.click;

public class SearchResultPage {
    private SelenideElement closeButtonWindow =  $(".DistributionButtonClose");


    public SearchResultPage closeButtonBrowser() {

        closeButtonWindow.click();

        return this;

    }

    public JuniorTariffSelection openLinkQaStudio(String QaStudioNameSite) {

        $(byText(QaStudioNameSite)).click();
        switchTo().window(1);

        return new JuniorTariffSelection();

    }
}
