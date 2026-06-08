package ru.budaev.qa;

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
         * 8. проверить, что к оплате 47 00р
         * */
        Configuration.holdBrowserOpen = true;
        open("https://ya.ru/");
        $("#text").setValue("bulgakov qa");
        $("[type=submit]").click();
        $(".DistributionButtonClose").click();
        $(byText("ivanbulgakovqa.ru")).click();
        sleep(3000);
        switchTo().window(1);
        $$(".t-menu__list li").last().click(); //xpath
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click();
        $(byText("Бегу оплачивать")).click();

        switchTo().window(2);
        $(".styles-module-scss-module__t92_WG__price").$("h3").shouldHave(text("₽ 47 000.00 "));
        //$(byText("₽ 47 000.00 ")).click();
    }


   @Test
   void myHomeTestNostalgy() {
// Тест-кейс - проверить, что обучение Qa Studio стоит 132000
       Configuration.holdBrowserOpen = true;  // 1. Открыть браузер
       open("https://ya.ru/");  // 2. Открыть поисковик
       $("#text").setValue("qa studio");  // 3. Ввести данные сайта (qa studio)
       $("[type=submit]").click(); // 4. Нажать на кнопку Поиск
       $(".DistributionButtonClose").click(); // 5. Закрыть всплывающее окно
       $(byText("manual.qa.studio")).click(); // 6. Перейти на сайт qa.studio
       switchTo().window(1); // Переход на новую вкладку
       $(byText("Записаться на курс")).shouldBe(visible).click(); // 7. Нажать на кнопку "Записаться на курс"

       $x("/html/body/main/section[20]/div[1]/div/div[2]/div/table/thead/tr/th[2]/div/div[3]/div/a").click(); // 8. Нажать на кнопку "К оплате" на тарифе Джуниор
       switchTo().window(2);

       $(byText("Тариф Джуниор")).shouldBe(visible).click(); // 9. Проверить, что действительно выбран тариф Джуниор
   }
    }
