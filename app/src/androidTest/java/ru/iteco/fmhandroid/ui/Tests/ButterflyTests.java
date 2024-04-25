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
import ru.iteco.fmhandroid.ui.Action.ButterflyAction;
import ru.iteco.fmhandroid.ui.Action.PanelAction;
import ru.iteco.fmhandroid.ui.AppActivity;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(AllureAndroidJUnit4.class)

public class ButterflyTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    String TrueLogin = "login2";
    String TruePassword = "password2";

    @Test
    @DisplayName("Раздел бабочка")
    public void butterflyPage() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationAction.loginPersonalAccount(TrueLogin, TruePassword);
        PanelAction.checkButtonLogIn();
        Thread.sleep(3000);
        ButterflyAction.butterflyPage();
    }

    @Test
    @DisplayName("Развернуть цитату")
    public void buttonArrow() throws InterruptedException {
        Thread.sleep(3000);
        ButterflyAction.arrowExpand();
    }



}