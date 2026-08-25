package ru.budaev.webshop;

import java.nio.channels.ConnectionPendingException;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest {

    @Test
    @DisplayName("Тест регистрации")

    void RegistrationTest(){
        open("https://demowebshop.tricentis.com/");

    }



//    open("https://demowebshop.tricentis.com/");

}
