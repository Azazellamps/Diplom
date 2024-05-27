package ru.iteco.fmhandroid.ui.Tests;

import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.Steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
public class MainTests {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityTestRule < AppActivity > mActivityTestRule =
            new ActivityTestRule < > (AppActivity.class);

    @Before
    public void startMain() {
    authorizationSteps.checkLogIn();
    mainSteps.mainPage();
    }

    @Test
    @DisplayName("Все Новости")
    public void AllNews() {
        mainSteps.checkAllNews();
    }

    @Test
    @DisplayName("Раздел Новости")
    public void pageNews() {
        mainSteps.checkMenuNews();
    }

    @Test
    @DisplayName("Раздел О приложении")
    public void pageAbout() {
        mainSteps.checkMenuAboutApp();
    }

    @Test
    @DisplayName("Раздел Главная")
    public void openHomePageOfNews() {
        mainSteps.checkHomePage();
    }
}