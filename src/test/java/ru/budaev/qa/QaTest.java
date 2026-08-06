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

// Тест-кейс - проверить, что обучение Qa Studio стоит 132000
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



       // 3. Ввести данные сайта (qa studio)
       //$("#text").setValue("manual qa studio"); // 1. открылся браузер ya.ru

       // 4. Нажать на кнопку Поиск
      // $("[type=submit]").click();

       // 5. Закрыть всплывающее окно
       //$(".DistributionButtonClose").click();

       // 6. Перейти на сайт qa.studio
      // $(byText("manual.qa.studio")).click(); // 2. Перейти на сайт qa.studio
      // switchTo().window(1); // Переход на новую вкладку

       // 7. Нажать на кнопку "Записаться на курс"
       //$(byText("Записаться на курс")).shouldBe(visible).click();

       // 8. Нажать на кнопку "К оплате" на тарифе Джуниор
       //$x("/html/body/main/section[20]/div[1]/div/div[2]/div/table/thead/tr/th[2]/div/div[3]/div/a").click(); // 3. перейти на страницу оплаты
      // switchTo().window(2);

       // 9. В блоке Джуниор нажать "К оплате"
       //$(byText("Тариф Джуниор")).shouldBe(visible).click();

       // 10. В поле "Кто будет учиться" ввести почту
       //$("#email").setValue("deniskoss@yandex.ru");

       // 11. мягкий скроллинг
       //$("#paySubmit").scrollIntoView(false);

       // 12. Нажать на кнопку "Перейти к оплате"
       //$x("/html/body/div/div[1]/form/div[2]/div/button").click();
       //$("#paySubmit").click();
    }
    }
