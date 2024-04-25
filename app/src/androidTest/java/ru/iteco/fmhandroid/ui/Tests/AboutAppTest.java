package ru.iteco.fmhandroid.ui.Tests;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.Action.AboutAppAction;
import ru.iteco.fmhandroid.ui.Action.AuthorizationAction;
import ru.iteco.fmhandroid.ui.Action.PanelAction;
import ru.iteco.fmhandroid.ui.AppActivity;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(AllureAndroidJUnit4.class)
public class AboutAppTest {

    @Rule
    public IntentsTestRule<AppActivity> intentsTestRule =
            new IntentsTestRule<>(ru.iteco.fmhandroid.ui.AppActivity.class);

    String TrueLogin = "login2";
    String TruePassword = "password2";



    @Test
    @DisplayName("Раздел о приложении")
    public void aboutSection() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(TrueLogin, TruePassword);
        PanelAction.checkButtonLogIn();
        Thread.sleep(3000);
        PanelAction.menuAboutTheApp();
        AboutAppAction.readAppPage();
    }

    @Test
    @DisplayName("Переход к политике конфиденциальности по ссылке")
    public void goPrivacyPolicy() throws InterruptedException {
        Thread.sleep(3000);
        PanelAction.menuAboutTheApp();
        AboutAppAction.goToPrivacyPolicy();
        AboutAppAction.checkPrivacyPolicy();

    }

    @Test
    @DisplayName("Переход к пользовательскому соглашению по ссылке")
    public void goTermsOfUse() throws InterruptedException {
        Thread.sleep(3000);
        PanelAction.menuAboutTheApp();
        AboutAppAction.goToTermsOfUse();
        AboutAppAction.checkTermsOfUse();
    }
    @Test
    @DisplayName("Кнопка вернуться на главную страницу")
    public void returnButton() throws InterruptedException {
        Thread.sleep(3000);
        PanelAction.menuAboutTheApp();
        AboutAppAction.readAppPage();
        AboutAppAction.returnButton();

    }

}
