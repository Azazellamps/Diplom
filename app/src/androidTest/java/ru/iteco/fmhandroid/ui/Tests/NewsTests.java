package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Page.NewsPage.myTittle;
import static ru.iteco.fmhandroid.ui.Page.NewsPage.category;
import static ru.iteco.fmhandroid.ui.Page.NewsPage.emptyCategory;
import static ru.iteco.fmhandroid.ui.Page.NewsPage.notCategory;
import static ru.iteco.fmhandroid.ui.Page.NewsPage.emptyDescription;
import static ru.iteco.fmhandroid.ui.Page.NewsPage.description;

import static ru.iteco.fmhandroid.ui.Page.NewsPage.emptyTittle;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Steps.AppAboutSteps;
import ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.Steps.MainSteps;
import ru.iteco.fmhandroid.ui.Steps.NewsSteps;;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTests {


    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();
    AppAboutSteps appAboutSteps =new AppAboutSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void startNews() {
        authorizationSteps.checkLogIn();
        mainSteps.mainPage();
        mainSteps.checkMenuNews();
    }

    @Test
    @DisplayName("Сортировка новостей")
    public void sortNews() {
        newsSteps.sortNews();
        newsSteps.checkNewsPage();
    }

    @Test
    @DisplayName("Переход в раздел о приложении из раздела Новости")
    public void aboutAppNews() {
//        тест не пройден, меню о приложении не активно
        mainSteps.checkMenuAboutApp();
        appAboutSteps.elementAppAbout();
    }

    @Test
    @DisplayName("Переход на страницу Фильтровать новости")
    public void filterNews() {
        newsSteps.checkNewsPage();
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
    }


    @Test
    @DisplayName("Проверка кнопки Отмена на странице Фильтровать новости")
    public void cancelButtonFilter() {
        newsSteps.checkNewsPage();
        newsSteps.filterNews();
        newsSteps.cancelButton();
        newsSteps.checkNewsPage();
    }

    @Test
    @DisplayName("Фильтровать новости из раздела Панель управления")
    public void filterControlPanel() {
        newsSteps.editNews();
        newsSteps.filterNews();
        newsSteps.checkFilterNews();
    }

    @Test
    @DisplayName("Отмена фильтрации новостей из Панели управления")
    public void cancelButtonFilterControlPanel() {
        newsSteps.editNews();
        newsSteps.filterNews();
        newsSteps.cancelButton();
        newsSteps.checkingControlPanelPage();
    }

    @Test
    @DisplayName("Переход на страницу Создать новость")
    public void createNews() {
        newsSteps.editNews();
        newsSteps.createNews();
        newsSteps.checkingCreateNewsPage();
    }

    @Test
    @DisplayName("Сортировка Панель управления")
    public void sortControlPanel() {
        newsSteps.editNews();
        newsSteps.sortNewsControlPanel();
        newsSteps.checkingControlPanelPage();
    }

    @Test
    @DisplayName("Создание новости. Валидные данные")
    public void createNewsControlPanel() {
        newsSteps.editNews();
        newsSteps.createNews();
        newsSteps.chooseCategory(category);
        newsSteps.createTittle(myTittle);
        newsSteps.dateCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.timeCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.createDescription(description);
        newsSteps.saveButton();
//проверка что новость появилась в списке
        newsSteps.checkNewsHasBeenCreated(myTittle);
    }

    @Test
    @DisplayName("Создание новости.Пустое поле категория")
    public void createNewsEmptyCategory() {
        newsSteps.editNews();
        newsSteps.createNews();
        newsSteps.chooseCategory(emptyCategory);
        newsSteps.createTittle(myTittle);
        newsSteps.dateCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.timeCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.createDescription(description);
        newsSteps.saveButton();
        newsSteps.emptyFields();
    }

    @Test
    @DisplayName("Создание новости. Пустое поле заголовок")
    public void createNewsEmptyTittle() {
        newsSteps.editNews();
        newsSteps.createNews();
        newsSteps.chooseCategory(category);
        newsSteps.createTittle(emptyTittle);
        newsSteps.dateCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.timeCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.createDescription(description);
        newsSteps.saveButton();
        newsSteps.emptyFields();
    }

    @Test
    @DisplayName("Создание новости. Пустое поле описание")
    public void createNewsEmptyDescription() {
        newsSteps.editNews();
        newsSteps.createNews();
        newsSteps.chooseCategory(category);
        newsSteps.createTittle(myTittle);
        newsSteps.dateCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.timeCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.createDescription(emptyDescription);
        newsSteps.saveButton();
        newsSteps.emptyFields();
    }

    @Test
    @DisplayName("Создание новости.Пустое поле дата")
    public void createNewsEmptyDate() {
        newsSteps.editNews();
        newsSteps.createNews();
        newsSteps.chooseCategory(category);
        newsSteps.createTittle(myTittle);
        newsSteps.timeCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.createDescription(description);
        newsSteps.saveButton();
        newsSteps.emptyFields();
    }

    @Test
    @DisplayName("Создание новости. Пустое поле время")
    public void createNewsEmptyTime() {
        newsSteps.editNews();
        newsSteps.createNews();
        newsSteps.chooseCategory(category);
        newsSteps.createTittle(myTittle);
        newsSteps.dateCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.createDescription(description);
        closeSoftKeyboard();
        newsSteps.saveButton();
        newsSteps.emptyFields();
    }

    @Test
    @DisplayName("Создание новости. Несуществующая категория")
    public void createNewsNonExistentCategory() {
        newsSteps.editNews();
        newsSteps.createNews();
        newsSteps.chooseCategory(notCategory);
        newsSteps.createTittle(myTittle);
        newsSteps.dateCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.timeCreatingNews();
        newsSteps.clickOkButton();
        newsSteps.createDescription(description);
        newsSteps.saveButton();
        newsSteps.nowCategory();
    }
}
