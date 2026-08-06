package ru.budaev.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.budaev.pages.Config;
import ru.budaev.pages.YandexSearchPage;
import ru.budaev.pagesQaStudio.SearchPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {
    private Object open;

    @Test
    @DisplayName("Проверить, что цена обучения 47000 руб")
    @Tag("POSITIVE")
    void mentoringPriceTest() {
        Config.setup();
        open("https://ya.ru/", YandexSearchPage.class)
                .search("bulgakov qa")
                .submit()
                .closeDefaultBrowserSelectWindow()
                .openLink("ivanbulgakovqa.ru")
                .clickPrice()
                .clickPayButton()
                .verifyPrice("₽ 47 000.00 ");
    }


   @Test
   @DisplayName("Запись на курс QaStudio, тариф Джуниор")
   @Tag("POSITIVE")
   void myHomeTestNostalgy() {

       Config.setup();
        open("https://ya.ru/", SearchPage.class)
                .searchQaStudio("manual qa studio")
                .submitButton()
                .closeButtonBrowser()
                .openLinkQaStudio("manual.qa.studio")
                .submitSignUp("Записаться на курс")
                .submitPaymentPage()
                .clickPayTariffJunior("Тариф Джуниор")
                .inputEmail("deniskoss@yandex.ru")
                .submitPay();
    }
    }
