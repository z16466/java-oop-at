package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java.oop.at.base.BaseTest;

@DisplayName("Авторизация")
public class AuthorizationTest  extends BaseTest {
    @DisplayName("Успешная авторизация")
    @Test
    public void auth() {
        driver.get("https://geekbrains.ru/login");
        String login = "hks47018@eoopy.com";
        String password = "hks47018";

        new ru.geekbrains.java.oop.at.page.sing.AuthorizationPage(driver)
                .authorization(login,password)
                .checkNamePage("Главная");
    }

}
