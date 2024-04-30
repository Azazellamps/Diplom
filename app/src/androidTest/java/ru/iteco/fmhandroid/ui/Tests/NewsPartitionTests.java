package ru.iteco.fmhandroid.ui.Tests;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.Action.AuthorizationAction;
import ru.iteco.fmhandroid.ui.Action.NewsPartitionAction;
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
    public void aRealTimeTest() throws InterruptedException {
        AuthorizationAction.loginPersonalAccount(TrueLogin, TruePassword);
        PanelAction.checkButtonLogIn();
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.newsRealTime();
    }

    @Test
    public void emptyNewsTest() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.creatingAnEmptyNews();
    }

    @Test
    public void publicationForNextYear() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.publicationForNextYear();
    }

    @Test
    public void filterNewsRealTime() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterRealTime();
    }

    @Test
    public void sortNewsTest() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
    }

        @Test
        public void filterButtonNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterButtonNews();
        NewsPartitionAction.filterForm();

    }

    @Test
    public void filterEmpty() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterEmpty();
    }

    @Test
    public void filterСancel() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterCancel();
    }

    @Test
    public void newCategoryFilter() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.nonExistentCategory();
    }

    @Test
    public void filterButtonIsNotActive() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterButtonIsNotActive();
    }

    @Test
    public void newsMonth () throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.publicationInAMonth();
    }
    @Test
    public void newsCancel() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.newsCancel();


    }

    @Test
    public void newCategoryNews() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.newCategoryNews();

    }
    @Test
    public void controlPanelSort() throws InterruptedException {
        Thread.sleep(3000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.controlPanelSortNews();

    }
            @Test
            public void filterButtonControlPanel() throws InterruptedException {
        Thread.sleep(5000);
        NewsPartitionAction.allNews();
        NewsPartitionAction.filterButtonControlPanel();
        NewsPartitionAction.filterForm();

    }

}



