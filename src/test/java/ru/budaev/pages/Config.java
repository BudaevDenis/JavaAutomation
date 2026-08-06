package ru.budaev.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class Config{
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-default-browser-check");
        options.addArguments("--disable-search-engine-choice-screen");

        Configuration.browser = "chrome"; // выбор браузера
        Configuration.pageLoadTimeout = 100000; // таймаут прогрузки страниц
        Configuration.timeout = 100000; // таймаут прогрузки элементов-
        Configuration.holdBrowserOpen = true;
    }
}
