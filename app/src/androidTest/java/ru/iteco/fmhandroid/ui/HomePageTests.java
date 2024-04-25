package ru.iteco.fmhandroid.ui;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;

import androidx.test.rule.ActivityTestRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(AllureAndroidJUnit4.class)

public class HomePageTests {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);
    String TrueLogin = "login2";
    String TruePassword = "password2";

    @Test
    @DisplayName("Отображение главной страницы ")
    public void HomePage() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(TrueLogin,TruePassword );
        PanelAction.checkButtonLogIn();
        Thread.sleep(3000);
        HomePageAction.homePageNews();
    }

    @Test
    @DisplayName("Развернуть раздел новости")
    public void arrowButtonNews() throws InterruptedException {
        Thread.sleep(3000);
      HomePageAction.arrowExpandNewsButton();
    }

    @Test
    @DisplayName("Развернуть новость в списке новстей")
    public void arrowNewsList() throws InterruptedException {
        Thread.sleep(3000);
        HomePageAction.arrowNewsFromTheList();
    }

    @Test
    @DisplayName("Меню переход в Новости")
    public void menuNews() throws InterruptedException {
        Thread.sleep(5000);
        PanelAction.newsBlock();

    }
    @Test
    @DisplayName("Меню переход в Главная")
    public void menuHome() throws InterruptedException {
        Thread.sleep(5000);
        PanelAction.menuHome();

    }


}
