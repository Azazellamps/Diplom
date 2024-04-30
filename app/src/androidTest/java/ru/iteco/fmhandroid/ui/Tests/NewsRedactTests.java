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

public class NewsRedactTests {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);
    String TrueLogin = "login2";
    String TruePassword = "password2";

    @Test
    public void activeNotActive() throws InterruptedException {
        Thread.sleep(5000);
        AuthorizationAction.loginPersonalAccount(TrueLogin, TruePassword);
        PanelAction.checkButtonLogIn();
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsRedactAction.newsControlPanel();
        NewsRedactAction.activeNotActive();
    }
    @Test
    public void canceldeleteNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsRedactAction.newsControlPanel();
        NewsRedactAction.cancelDeleteNews();
    }

    @Test
    public void deleteNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsRedactAction.newsControlPanel();
        NewsRedactAction.deleteNews();
    }


    @Test
    public void editingNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsRedactAction.newsControlPanel();
        NewsRedactAction.editNews();
    }

    @Test
    public void editingNewsCancel() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsRedactAction.newsControlPanel();
        NewsRedactAction.editNewsCancel();
    }
}