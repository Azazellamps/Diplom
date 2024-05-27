package ru.iteco.fmhandroid.ui.Tests;

import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.TrueLogin;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.TruePassword;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.EmptyLoginAndPassword;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.ErrorLoginAndPassword;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.IncorrectLogin;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.IncorrectPassword;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.SymbolsLogin;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.SymbolsPassword;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.Steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.Steps.MainSteps;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTests {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityTestRule < AppActivity > mActivityTestRule =
            new ActivityTestRule < > (AppActivity.class);

    @Before
    public void startAuthorization() {
        authorizationSteps.loadingAuthorization();
        try {
            authorizationSteps.windowAuthorization();
        } catch (NoMatchingViewException e) {
            mainSteps.logOut();
        }
    }


    @Test
    @DisplayName("Авторизация. Валидные данные")
    public void validAuthorization() {
        authorizationSteps.windowAuthorization();
        authorizationSteps.validAuthorization();
        mainSteps.logOut();
    }

    @Test
    @DisplayName("Авторизация. Невалидный логин")
    public void invalidLogin() {
        authorizationSteps.windowAuthorization();
        authorizationSteps.fillInTheLoginField(IncorrectLogin);
        authorizationSteps.fillInThePasswordField(TruePassword);
        authorizationSteps.signInButton();
        authorizationSteps.errorLoginAndPassword();
    }

    @Test
    @DisplayName("Авторизация. Невалидный пароль")
    public void invalidPassword() {
        authorizationSteps.windowAuthorization();
        authorizationSteps.fillInTheLoginField(TrueLogin);
        authorizationSteps.fillInThePasswordField(IncorrectPassword);
        authorizationSteps.signInButton();
        authorizationSteps.errorLoginAndPassword();
    }

    @Test
    @DisplayName("Авторизация. Пустые поля логин и пароль")
    public void emptyAuthorization() {
        authorizationSteps.windowAuthorization();
        authorizationSteps.signInButton();
        authorizationSteps.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Авторизация. Символы в полях логин и пароль")
    public void loginCharacters() {
        authorizationSteps.windowAuthorization();
        authorizationSteps.fillInTheLoginField(SymbolsLogin);
        authorizationSteps.fillInThePasswordField(SymbolsPassword);
        authorizationSteps.signInButton();
        authorizationSteps.errorLoginAndPassword();
    }

}

