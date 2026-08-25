package ru.budaev.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.budaev.pages.YandexSearchPage;
import ru.budaev.pages.bulgakov.ResultCostPage;
import ru.budaev.pages.bulgakov.WelcomePage;
import ru.budaev.pages.qastudio.CoursesPage;
import ru.budaev.pages.qastudio.TariffPaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class QaTest extends BaseTest {

    @Test
    @DisplayName("Проверить, что цена обучения 47 000 руб")
    @Tag("positive")
    void mentoringPriceShouldBe47000Test() {
        open("https://ya.ru/", YandexSearchPage.class)
                .search("bulgakov qa")
                .submit()
                .closeDefaultBrowserBannerIfAppeared()
                .closeDistributionBannerIfAppeared()
                .openLink("ivanbulgakovqa.ru")

                // сайт открылся новой вкладкой
                .switchToWindow(1, WelcomePage.class)
                .openStudySection()
                .clickWantToQa()
                .clickRunToPay()

                // оплата открылась ещё одной вкладкой
                .switchToWindow(2, ResultCostPage.class)
                .checkPriceAmount("47 000");
    }

    @Test
    @DisplayName("Запись на курс QA Studio, тариф Джуниор")
    @Tag("positive")
    void signUpForJuniorTariffTest() {
        open("https://ya.ru/", YandexSearchPage.class)
                .search("manual qa studio")
                .submit()
                .closeDefaultBrowserBannerIfAppeared()
                .closeDistributionBannerIfAppeared()
                .openLink("manual.qa.studio")

                // сайт открылся новой вкладкой
                .switchToWindow(1, CoursesPage.class)
                .openSignUpSection()
                .clickPayForTariff("Джуниор")

                // оплата открылась ещё одной вкладкой
                .switchToWindow(2, TariffPaymentPage.class)
                .selectTariff("Тариф Джуниор")
                .fillEmail("deniskoss@yandex.ru")

                // до кнопки оплаты доходим, но не жмём: это боевой платёж
                .checkEmail("deniskoss@yandex.ru")
                .checkPayButtonIsReady();
    }
}
