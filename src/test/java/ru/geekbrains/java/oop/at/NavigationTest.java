package ru.geekbrains.java.oop.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.java.oop.at.base.BaseTest;
import ru.geekbrains.java.oop.at.block.LeftNavigation;
import ru.geekbrains.java.oop.at.page.content.TestPage;

import java.util.stream.Stream;

@Feature("Навигация")
@Story("Переход на страницы")
@DisplayName("Переход на страницы")
public class NavigationTest extends BaseTest {

//    Перейти на сайт https://geekbrains.ru/events
//    Нажать на кнопку Курсы
//    Проверить что страница Курсы открылась
//    Повторить для
//    Курсы
//    Вебинары
//    Форум
//    Блог
//    Тесты
//    Карьера
//    Реализовать проверку отображения блоков Header и Footer на каждой странице сайта (как минимум самого блока)

    @Description("Тесты которые проверяют функционал без Pop-UP")
    @DisplayName("Нажатие на элемент навагации")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("stringProviderNotPopUp")
    public void checkNavigationNotPopUp(LeftNavigation.Button button) {
        new TestPage(driver)
                .openUrl()
                .getLeftNavigation().clickButton(button)
                .getHeader().checkNamePage(button.getText());
    }

    public static Stream<LeftNavigation.Button> stringProviderNotPopUp() {
        return Stream.of(
                LeftNavigation.Button.TOPICS,
                LeftNavigation.Button.EVENTS,
                LeftNavigation.Button.TESTS,
                LeftNavigation.Button.CAREER
        );
    }

    @Test
    public void checkNavigationPopUp() {
        new TestPage(driver)
                .openUrl()
                .getLeftNavigation().clickButton(LeftNavigation.Button.POSTS)
                .closedPopUp()
                .getHeader().checkNamePage(LeftNavigation.Button.POSTS.getText());
    }
}