package ru.budaev.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

public class Config{
    public static void setup(){
        Configuration.browser = "chrome"; // выбор браузера
        Configuration.pageLoadTimeout = 100000; // таймаут прогрузки страниц
        Configuration.timeout = 100000; // таймаут прогрузки элементов-
        Configuration.holdBrowserOpen = true;
    }
}
