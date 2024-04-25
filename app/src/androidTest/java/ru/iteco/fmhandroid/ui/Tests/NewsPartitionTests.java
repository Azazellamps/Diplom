package ru.iteco.fmhandroid.ui.Tests;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.Action.AuthorizationAction;
import ru.iteco.fmhandroid.ui.Action.NewsPartitionAction;
import ru.iteco.fmhandroid.ui.Action.NewsRedactAction;
import ru.iteco.fmhandroid.ui.Action.PanelAction;
import ru.iteco.fmhandroid.ui.AppActivity;

import androidx.test.rule.ActivityTestRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(AllureAndroidJUnit4.class)

public class NewsPartitionTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);
    String TrueLogin = "login2";
    String TruePassword = "password2";

    @Test
    @DisplayName("Создание новости с валидными значениями")
    public void aRealTimeTest() throws InterruptedException {
        AuthorizationAction.loginPersonalAccount(TrueLogin, TruePassword);
        PanelAction.checkButtonLogIn();
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.newsRealTime();
    }

    @Test
    @DisplayName("Создание пустой новости")
    public void emptyNewsTest() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.creatingAnEmptyNews();
    }

    @Test
    @DisplayName("Создание новости с публикацией через год")
    public void publicationForNextYear() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.publicationForNextYear();
    }

    @Test
    @DisplayName("Фильтрация новостей.Валидные данные")
    public void filterNewsRealTime() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterRealTime();
    }

    @Test
    @DisplayName("Кнопка сортировки новостей")
    public void sortNewsTest() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
    }

        @Test
    @DisplayName("Кнопка фильтр новостей")
    public void filterButtonNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterButtonNews();
        NewsPartitionAction.filterForm();

    }

    @Test
    @DisplayName("Пустой фильтр")
    public void filterEmpty() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterEmpty();
    }

    @Test
    @DisplayName("Отменить фильтрацию")
    public void filterСancel() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterCancel();
    }

    @Test
    @DisplayName("Новая категория")
    public void newCategoryFilter() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.nonExistentCategory();
    }

    @Test
    @DisplayName("Панель управления. Фильтр нажать кнопку не активна")
    public void filterButtonIsNotActive() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterButtonIsNotActive();
    }

    @Test
    @DisplayName("Создание новости публикация через месяц")
    public void newsMonth () throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.publicationInAMonth();
    }
    @Test
    @DisplayName("Создание новости отмена")
    public void newsCancel() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.newsCancel();


    }

    @Test
    @DisplayName("Создание новости.Новая категория")
    public void newCategoryNews() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.newCategoryNews();

    }
    @Test
    @DisplayName("Сортировать новости панель управления")
    public void controlPanelSort() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.controlPanelSortNews();

    }
            @Test
    @DisplayName("Кнопка фильтр новостей панель управления")
    public void filterButtonControlPanel() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterButtonControlPanel();
        NewsPartitionAction.filterForm();

    }

}



