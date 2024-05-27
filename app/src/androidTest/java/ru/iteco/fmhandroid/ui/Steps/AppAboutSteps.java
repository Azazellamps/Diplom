package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.Page.AboutAppPage;

public class AppAboutSteps {
    AboutAppPage aboutAppPage = new AboutAppPage();


    public void clickBackButton() {
        Allure.step("Кнопка возврат");
        aboutAppPage.backButton.perform(click());
    }

    public void goToPrivacyPolicy() {
        Allure.step("Проверка кликабильности надписи Политика конфиденциальности");
        aboutAppPage.privacyPolicy.perform(click());
    }

    public void goToTermsOfUse() {
        Allure.step("Проверка кликабельности надписи Пользовательское соглашение");
        aboutAppPage.termsOfUse.perform(click());
    }

    public void goToPrivacyPolicyLink() {
        Allure.step("Переход по ссылке Политика конфиденциальности");
        aboutAppPage.privacyPolicyLink.perform(click());
    }

    public void goToTermsOfUseLink() {
        Allure.step("Переход по ссылке Пользовательское соглашение ");
        aboutAppPage.termsOfUseLink.perform(click());
    }

    public void elementAppAbout() {
        Allure.step("Проверка элементов экрана О приложении");
        aboutAppPage.aboutAppLogo.check(matches(isDisplayed()));
        aboutAppPage.version.check(matches(isDisplayed()));
        aboutAppPage.versionNumber.check(matches(isDisplayed()));
        aboutAppPage.privacyPolicy.check(matches(isDisplayed()));
        aboutAppPage.privacyPolicyLink.check(matches(isDisplayed()));
        aboutAppPage.termsOfUse.check(matches(isDisplayed()));
        aboutAppPage.termsOfUseLink.check(matches(isDisplayed()));
        aboutAppPage.backButton.check(matches(isDisplayed()));
    }




}