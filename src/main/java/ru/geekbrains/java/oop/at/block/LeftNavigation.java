package ru.geekbrains.java.oop.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.java.oop.at.BasePageObject;
import ru.geekbrains.java.oop.at.page.content.CoursePage;
import ru.geekbrains.java.oop.at.page.content.HomePage;
import ru.geekbrains.java.oop.at.page.content.TestPage;
import ru.geekbrains.java.oop.at.page.content.base.ContentBasePage;

public class LeftNavigation extends BasePageObject {

    @FindBy(css = "[class='svg-icon icon-logo']")
    private WebElement icon;

    @FindBy(css = "[id='nav'] [href='/courses']")
    private WebElement buttonCourses;

    @FindBy(css = "[id='nav'] [href='/events']")
    private WebElement buttonEvents;

    @FindBy(css = "[id='nav'] [href='/topics']")
    private WebElement buttonTopics;

    @FindBy(css = "[id='nav'] [href='/posts']")
    private WebElement buttonPosts;

    @FindBy(css = "[id='nav'] [href='/tests']")
    private WebElement buttonTests;

    @FindBy(css = "[id='nav'] [href='/career']")
    private WebElement buttonCareer;

    public LeftNavigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Step("Нажатие кнопки {nameButton}")
    public ContentBasePage clickButton(Button button) {
        ContentBasePage contentBasePage = null;

        switch (button) {
            case ICON:
                icon.click();
                contentBasePage = new HomePage(driver);
                break;
            case COURSES:
                buttonCourses.click();
                contentBasePage = new CoursePage(driver);
                break;
            case EVENTS:
                //TODO доработать под другие кнопки
                buttonEvents.click();
                break;
            case TOPICS:
                //TODO доработать под другие кнопки
                buttonTopics.click();
                break;
            case POSTS:
                //TODO доработать под другие кнопки
                buttonPosts.click();
                break;
            case TESTS:
                buttonTests.click();
                contentBasePage = new TestPage(driver);
                break;
            case CAREER:
                //TODO доработать под другие кнопки
                buttonCareer.click();
                break;
        }
        if (contentBasePage == null) {
            contentBasePage = new HomePage(driver);
        }
        return contentBasePage;
    }

    public enum Button {
        ICON("Главная"),
        COURSES("Курсы"),
        EVENTS("Вебинары"),
        TOPICS("Форум"),
        POSTS("Блог"),
        TESTS("Тесты"),
        CAREER("Карьера");

        private String text;

        Button(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}