package ru.iteco.fmhandroid.ui.Tests;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.Action.AuthorizationAction;
import ru.iteco.fmhandroid.ui.Action.NewsAction;
import ru.iteco.fmhandroid.ui.Action.NewsEditingAction;
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

public class NewsEditingTests {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);
    String TrueLogin = "login2";
    String TruePassword = "password2";

    @Test
    @DisplayName("Сделать новость неактивной")
    public void activeNotActive() throws InterruptedException {
        Thread.sleep(5000);
        AuthorizationAction.loginPersonalAccount(TrueLogin, TruePassword);
        PanelAction.checkButtonLogIn();
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsEditingAction.newsControlPanel();
        NewsEditingAction.activeNotActive();
    }
    @Test
    @DisplayName("Отмена удаления новости")
    public void canceldeleteNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsEditingAction.newsControlPanel();
        NewsEditingAction.cancelDeleteNews();
    }


    @Test
    @DisplayName("Удаление новости")
    public void deleteNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsEditingAction.newsControlPanel();
        NewsEditingAction.deleteNews();
    }


    @Test
    @DisplayName("Редактирование новости")
    public void editingNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsEditingAction.newsControlPanel();
        NewsEditingAction.editNews();
    }

    @Test
    @DisplayName("Отмена редактирования новости")
    public void editingNewsCancel() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsEditingAction.newsControlPanel();
        NewsEditingAction.editNewsCancel();
    }
}