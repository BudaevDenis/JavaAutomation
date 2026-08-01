package ru.budaev.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.budaev.pages.YandexSearchPage;
import ru.budaev.pages.YandexSearchResultPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {
    private Object open;

    @Test
    void mentoringPriceTest() {

        Configuration.browser = "chrome"; // выбор браузера
        Configuration.pageLoadTimeout = 100000; // таймаут прогрузки страниц
        Configuration.timeout = 100000; // таймаут прогрузки элементов-
        Configuration.holdBrowserOpen = true;

        YandexSearchPage yaSearch = new YandexSearchPage();
        YandexSearchResultPage yaSearchResults = new YandexSearchResultPage();

        open("https://ya.ru/");
        yaSearch
                .search("bulgakov qa")
                .submit()
                .closeDefaultBrowserSelectWindow()
                .openLink("ivanbulgakovqa.ru")
                .clickPrice()
                .clickPayButton()
                .verifyPrice("₽ 47 000.00 ");

    }


   @Test
   void myHomeTestNostalgy() {
// Тест-кейс - проверить, что обучение Qa Studio стоит 132000
       // 1. Открыть браузер
       Configuration.holdBrowserOpen = true;

       // 2. Открыть поисковик
       open("https://ya.ru/");

       // 3. Ввести данные сайта (qa studio)
       $("#text").setValue("qa studio");

       // 4. Нажать на кнопку Поиск
       $("[type=submit]").click();

       // 5. Закрыть всплывающее окно
       $(".DistributionButtonClose").click();

       // 6. Перейти на сайт qa.studio
       $(byText("manual.qa.studio")).click();
       switchTo().window(1); // Переход на новую вкладку

       // 7. Нажать на кнопку "Записаться на курс"
       $(byText("Записаться на курс")).shouldBe(visible).click();

       // 8. Нажать на кнопку "К оплате" на тарифе Джуниор
       $x("/html/body/main/section[20]/div[1]/div/div[2]/div/table/thead/tr/th[2]/div/div[3]/div/a").click();
       switchTo().window(2);

       // 9. Проверить, что действительно выбран тариф Джуниор
       $(byText("Тариф Джуниор")).shouldBe(visible).click();

       // 10. В поле "Кто будет учиться" ввести почту
       $("#email").setValue("deniskoss@yandex.ru");

       // 11. мягский скроллинг
       $("#paySubmit").scrollIntoView(false);

       // 12. Нажать на кнопку "Перейти к оплате"
       //$x("/html/body/div/div[1]/form/div[2]/div/button").click();
       $("#paySubmit").click();
    }
    }
