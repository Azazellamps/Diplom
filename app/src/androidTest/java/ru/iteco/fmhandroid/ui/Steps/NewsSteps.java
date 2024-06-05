package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static ru.iteco.fmhandroid.ui.Data.Helper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.Page.NewsPage.fillInTheBlankFields;
import static ru.iteco.fmhandroid.ui.Page.NewsPage.saveFailed;


import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.ui.Page.NewsPage;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class NewsSteps {


    NewsPage newsPage = new NewsPage();

    public void checkNewsPage() {
        Allure.step("Новости");
        newsPage.newsList.check(matches(isDisplayed()));
    }

    public void checkFilterNews() {
        Allure.step("Фильтровать новости");
        newsPage.filterNews.check(matches(isDisplayed()));
    }

    public void sortNews() {
        Allure.step("Сортировка");
        newsPage.sort.perform(click());
    }

    public void filterNews() {
        Allure.step("Нажать кнопку Фильтровать ");
        newsPage.filter.perform(click());
    }

    public void editNews() {
        Allure.step("Нажать кнопку Редактирование");
        newsPage.edit.perform(click());
    }

    public void emptyFields(){
        Allure.step("Проверка пустых полей");
        onView(Matchers.allOf(withContentDescription(fillInTheBlankFields), isDisplayed()));
    }

    public void nowCategory(){
        Allure.step("Проверка новая категория");
        onView(Matchers.allOf(withContentDescription(saveFailed), isDisplayed()));
    }

    public void dateCreatingNews(){
        Allure.step("Выбор даты");
        newsPage.data.perform(click());
    }
    public void timeCreatingNews(){
        Allure.step("Выбор времени");
        newsPage.time.perform(click());
    }
    public void clickOkButton(){
        Allure.step("Нажать кнопку ОК");
        newsPage.okButton.perform(click());
    }

    public void checkingControlPanelPage() {
        Allure.step("Проверка страницы Панель управления");
        newsPage.inRoot.perform(waitDisplayed(R.id.news_list_recycler_view, 5000));
        newsPage.controlPanelText.check(matches(isDisplayed()));
    }

    public void sortNewsControlPanel() {
        Allure.step("Сортировка Панель управления");
        newsPage.sortControlPanel.perform(click());
    }

    public void createNews() {
        Allure.step("Создание Панель управления");
        newsPage.createControlPanel.perform(click());
    }

    public void checkingCreateNewsPage() {
        Allure.step("Проверка страницы создание новости");
        newsPage.creatingPage.check(matches(isDisplayed()));
    }

    public void chooseCategory(String text) {
        Allure.step("Выбрать категорию");
        newsPage.createCategory.perform(click());
        newsPage.createCategory.perform(replaceText(text));
    }

    public void createTittle(String text) {
        Allure.step("Создать заголовок");
        newsPage.createTitle.perform(replaceText(text));
    }

    public void createDescription(String description) {
        Allure.step("Создать описание");
        newsPage.createDescription.perform(replaceText(description));
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        newsPage.saveButton.perform(click());
    }

    public void cancelButton() {
        Allure.step("Нажать на кнопку отменить");
        newsPage.cancelButton.perform(click());
    }
    public void checkNewsHasBeenCreated(String titleText) {
        Allure.step("Проверка созданной новости");
        onView(allOf(withText(titleText), isDisplayed())).check(matches(isDisplayed()));
    }


}


