package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseTest;

import java.util.stream.Stream;

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

    @AfterEach
    void tearDown() {
        WebElement header = chromeDriver.findElementByCssSelector("header#top-menu");
        WebElement footer = chromeDriver.findElementByCssSelector("footer[class=\"site-footer\"]");

        wait15second.until(ExpectedConditions.visibilityOf(header));
        wait15second.until(ExpectedConditions.visibilityOf(footer));
    }

    @DisplayName("Нажатие на элемент навигации \"Блог\"")
    @Test
    public void posts() {
        chromeDriver.findElement(By.cssSelector("[id=\"nav\"] [href=\"/posts\"]")).click();

        chromeDriver.findElement(By.cssSelector("[class=\"gb-empopup-close\"]")).click();
        chromeDriver.findElement(By.cssSelector("button [class=\"svg-icon icon-popup-close-button \"]")).click();

        Assertions.assertEquals(
                "Блог",
                chromeDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText()
        );
    }

    @DisplayName("Нажатие на остальные элементы навигации")
    @ParameterizedTest
    @MethodSource("dataNavButton")
    public void navButton(String namePage, String valueHref) {
        chromeDriver.findElement(By.cssSelector("[id=\"nav\"] [href='/" + valueHref + "']")).click();
        Assertions.assertEquals(
                namePage,
                chromeDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText()
        );
    }

    public static Stream<Arguments> dataNavButton() {
        return Stream.of(
                Arguments.of("Курсы", "courses"),
                Arguments.of("Вебинары", "events"),
                Arguments.of("Форум", "topics"),
                Arguments.of("Тесты", "tests"),
                Arguments.of("Карьера", "career")
        );
    }
}