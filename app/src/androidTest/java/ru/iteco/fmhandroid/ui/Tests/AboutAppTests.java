package ru.iteco.fmhandroid.ui.Tests;

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


@RunWith(AllureAndroidJUnit4.class)
public class AboutAppTests {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    AppAboutSteps appAboutSteps = new AppAboutSteps();


    @Rule
    public ActivityTestRule < AppActivity > mActivityTestRule =
            new ActivityTestRule < > (AppActivity.class);

    @Before
    public void startAboutApp() {
        authorizationSteps.checkLogIn();
        mainSteps.mainPage();
        mainSteps.checkMenuAboutApp();
    }
    @Test
    @DisplayName("Проверка элементов страницы О приложении")
    public void checkAboutAppElements() {
        appAboutSteps.elementAppAbout();
    }

    @Test
    @DisplayName("Переход по ссылке Политика конфиденциальности")
    public void followingALinkPrivacyPolicy() {
        appAboutSteps.goToPrivacyPolicy();
        appAboutSteps.goToPrivacyPolicyLink();
    }

    @Test
    @DisplayName("Переход по ссылке Пользовательское соглашение")
    public void followingALinkTermsOfUse() {
        appAboutSteps.goToTermsOfUse();
        appAboutSteps.goToTermsOfUseLink();
    }

    @Test
    @DisplayName("Кликабельность кнопки Назад")
    public void backButtonClick() {
        appAboutSteps.elementAppAbout();
        appAboutSteps.clickBackButton();
        mainSteps.mainPage();
    }
}