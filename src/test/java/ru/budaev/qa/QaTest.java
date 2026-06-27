package ru.budaev.qa;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SetValueMethod;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {
    private Object open;

    @Test
    void mentoringPriceTest() {
        /* Тест-кейс - проверить, что предоплата 49000р
         * 1. открыть поисковик
         * 2. ввести данные (bulgakov qa)
         * 3. нажать кнопку поиск
         * 4. в поисковой выдаче найти нужный сайт, кликнуть на него
         * 5. нажать на кнопку "Стоимость"
         * 6. нажать на кнопку "Вкатиться в QA"
         * 7. нажать на кнопку "Бегу оплачивать"
         * 8. проверить, что к оплате 47 000р
         * */
        Configuration.browser = "chrome"; // выбор браузера
        Configuration.pageLoadTimeout = 200000; // таймаут прогрузки страниц
        Configuration.timeout = 200000; // таймаут прогрузки элементов

        Configuration.holdBrowserOpen = true;
        open("https://ya.ru/");
        $("#text").setValue("bulgakov qa"); //яндекс поиск
        $("[type=submit]").click();
        $(".DistributionButtonClose").click();

         // поисковая выдача
        $(byText("ivanbulgakovqa.ru")).click();

        sleep(3000);
        switchTo().window(1);
        $$(".t-menu__list li").last().click(); // welcome страница обучения
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click(); // xpath
        $(byText("Бегу оплачивать")).click();

        switchTo().window(2);
        $(".styles-module-scss-module__kWKzya__price").shouldHave(text("₽ 47 000.00 "));
        // страница оплаты

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
