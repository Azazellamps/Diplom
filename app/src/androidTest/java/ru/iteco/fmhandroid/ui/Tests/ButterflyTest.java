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
import ru.iteco.fmhandroid.ui.Steps.ButterflySteps;
import ru.iteco.fmhandroid.ui.Steps.MainSteps;


@RunWith(AllureAndroidJUnit4.class)
public class ButterflyTest {

    String quoteText = "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер";

    ButterflySteps butterflySteps = new ButterflySteps();
    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public androidx.test.rule.ActivityTestRule < AppActivity > ActivityTestRule = new ActivityTestRule < > (AppActivity.class);
    @Before
    public void startButterfly() {
        authorizationSteps.checkLogIn();
        mainSteps.mainPage();
        butterflySteps.clickButterflyButton();
    }

    @Test
    @DisplayName("Проверка элементов экрана с тематическими цитатами")
    public void elementQuote() {
        butterflySteps.elementQuote();
    }

    @Test
    @DisplayName("Свернуть/развернуть цитату")
    public void quoteCollapseExpand() {
        butterflySteps.expandQuote(0);
        butterflySteps.descriptionQuote(quoteText);
        butterflySteps.expandQuote(0);
    }
}
