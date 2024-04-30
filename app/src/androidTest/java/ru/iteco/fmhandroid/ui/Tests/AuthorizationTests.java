package ru.iteco.fmhandroid.ui.Tests;

import androidx.test.rule.ActivityTestRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.Action.AuthorizationAction;
import ru.iteco.fmhandroid.ui.Action.PanelAction;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void autarizationSuccessful() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(TrueLogin,TruePassword );
        PanelAction.checkButtonLogIn();
        PanelAction.logOut();

    }

    @Test
    public void incorrectLoginAndPassword() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(IncorrectLogin,IncorrectPassword);
        PanelAction.checkButtonLogIn();
        AuthorizationAction.textAuthorization();
    }
    @Test
    public void correctPasswordWrongLogin() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(EroneousLogin, TruePassword);
        AuthorizationAction.buttonAuthorization();
        AuthorizationAction.textAuthorization();
    }
    @Test
    public void correctLoginWrongPassword() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(TrueLogin, ErroneousPassword);
        AuthorizationAction.buttonAuthorization();
        AuthorizationAction.textAuthorization();
    }

    @Test
    public void emptyloginAndPassword() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.buttonAuthorization();
        AuthorizationAction.textAuthorization();
    }

    @Test
    public void logOut() throws InterruptedException {
        AuthorizationAction.loginPersonalAccount(TrueLogin,TruePassword );
        PanelAction.logOut();

    }
}