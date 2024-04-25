package ru.iteco.fmhandroid.ui;

import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;


@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTests {
    @Rule
    public ActivityTestRule<ru.iteco.fmhandroid.ui.AppActivity> activityTestRule =
            new ActivityTestRule<>(ru.iteco.fmhandroid.ui.AppActivity.class);

    String TrueLogin = "login2";
    String TruePassword = "password2";

    String IncorrectLogin = "login@3";
    String IncorrectPassword = "password@3";

    String EroneousLogin = "login555";
    String ErroneousPassword = "password555";

    @Test
    @DisplayName("Авторизация. Верный логин и пароль")
    public void autarizationSuccessful() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(TrueLogin,TruePassword );
        PanelAction.checkButtonLogIn();
        PanelAction.logOut();

    }

    @Test
    @DisplayName("Авторизация. Неверный логин и пароль")
    public void incorrectLoginAndPassword() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(IncorrectLogin,IncorrectPassword);
        PanelAction.checkButtonLogIn();
        AuthorizationAction.textAuthorization();
    }
    @Test
    @DisplayName("Авторизация. Ошибочный логин верный пароль")
    public void wrongLoginCorrectPassword() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(EroneousLogin, TruePassword);
        AuthorizationAction.buttonAuthorization();
        AuthorizationAction.textAuthorization();
    }
    @Test
    @DisplayName("Авторизация. Верный логин ошибочный пароль")
    public void correctLoginWrongPassword() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(TrueLogin, ErroneousPassword);
        AuthorizationAction.buttonAuthorization();
        AuthorizationAction.textAuthorization();
    }

    @Test
    @DisplayName("Авторизация. Логин и пароль пустые поля")
    public void loginAndPasswordAreEmpty() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.buttonAuthorization();
        AuthorizationAction.textAuthorization();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logOut() throws InterruptedException {
        AuthorizationAction.loginPersonalAccount(TrueLogin,TruePassword );
        PanelAction.logOut();

    }
}