package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.java.oop.at.base.BaseTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Проверка поиска")
public class SearchTest extends BaseTest {

//    Перейти на сайт https://geekbrains.ru/events
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что на странице:
//    Профессий не менее чем 2
//    Курсов более 15
//    Вебинаров больше чем 180, но меньше 300
//    В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
//    Блогов более 300
//    Форумов не 350
//    Тестов не 0
//    В Проектах и компаниях отображается GeekBrains

@DisplayName("Проверка поиска по блокам")
    @Test
    void search() {
        WebElement buttonSearch = chromeDriver.findElement(By.cssSelector("[class=\"gb-top-menu__item\"] [class=\"show-search-form\"] [class*=\"svg-icon\"]"));
        buttonSearch.click();
        WebElement inputSearch = chromeDriver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");

        WebElement professions = chromeDriver.findElement(By.xpath(".//header/h2[text()='Профессии']"));
        WebElement courses = chromeDriver.findElement(By.xpath(".//header/h2[text()='Курсы']"));
        WebElement webinars = chromeDriver.findElement(By.xpath(".//header/h2[text()='Вебинары']"));
        WebElement blogs = chromeDriver.findElement(By.xpath(".//header/h2[text()='Блоги']"));
        WebElement forum = chromeDriver.findElement(By.xpath(".//header/h2[text()='Форум']"));
        WebElement tests = chromeDriver.findElement(By.xpath(".//header/h2[text()='Тесты']"));
        WebElement projectAndCompany = chromeDriver.findElement(By.xpath("//header/h2[text()='Проекты и компании']"));

        WebElement professionsCount = chromeDriver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='professions']/span"));
        WebElement coursesCount = chromeDriver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='courses']/span"));
        WebElement webinarsCount = chromeDriver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='webinars']/span"));
        WebElement blogsCount = chromeDriver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='blogs']/span"));
        WebElement forumsCount = chromeDriver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='forums']/span"));
        WebElement testsCount = chromeDriver.findElement(By.xpath("//a[@class='search-page-block__more' and @data-tab='tests']/span"));

        WebElement webinarsList = chromeDriver.findElement(By.xpath("//a[@class='event__title h3 search_text']"));

        WebElement gbCompany = chromeDriver.findElement(By.xpath("//div[@class='company-items']//h3/a[contains(text(),'GeekBrains')]"));

        wait15second.until(ExpectedConditions.textToBePresentInElement(professions, "Профессии"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(courses, "Курсы"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(webinars, "Вебинары"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(blogs, "Блоги"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(forum, "Форум"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(tests, "Тесты"));
        wait15second.until(ExpectedConditions.textToBePresentInElement(projectAndCompany, "Проекты и компании"));

        assertThat(Integer.parseInt(professionsCount.getText()), greaterThanOrEqualTo(2));
        assertThat(Integer.parseInt(coursesCount.getText()), greaterThan(15));
        assertThat(Integer.parseInt(webinarsCount.getText()), allOf(greaterThan(180), lessThan(300)));
        assertThat(Integer.parseInt(blogsCount.getText()), greaterThan(300));
        assertThat(Integer.parseInt(forumsCount.getText()), not(equalTo(350)));
        assertThat(Integer.parseInt(testsCount.getText()), not(equalTo(0)));
        assertThat(webinarsList.getText(), equalTo("Java Junior. Что нужно знать для успешного собеседования?"));

        assertThat(gbCompany, notNullValue());
    }
}