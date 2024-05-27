package ru.iteco.fmhandroid.ui.Steps;

import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.TrueLogin;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.TruePassword;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.EmptyLoginAndPassword;
import static ru.iteco.fmhandroid.ui.Page.AuthorizationPage.ErrorLoginAndPassword;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Helper;
import ru.iteco.fmhandroid.ui.Page.AuthorizationPage;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.Data.Helper.waitDisplayed;

public class AuthorizationSteps {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainSteps mainSteps = new MainSteps();
    Helper helper = new Helper();


    public void windowAuthorization() {
        Allure.step("Окно Авторизация");
        authorizationPage.authorization.check(matches(isDisplayed()));
    }

    public void loadingAuthorization(){
        Allure.step("Загрузка");
        authorizationPage.inRoot.perform(waitDisplayed(R.id.container_custom_app_bar_include_on_fragment_main, 10000));
    }

    public void fillInTheLoginField(String login) {
        Allure.step("Заполнение поля логин");
        authorizationPage.loginField.check(matches(isEnabled()));
        authorizationPage.loginField.perform(replaceText(login));
    }

    public void fillInThePasswordField(String password) {
        Allure.step("Заполнение поля пароль");
        authorizationPage.passwordField.check(matches(isEnabled()));
        authorizationPage.passwordField.perform(replaceText(password));
    }

    public void signInButton() {
        Allure.step("Нажать кнопку Войти");
        authorizationPage.signInButton.perform(click());
    }

    public void validAuthorization(){
        Allure.step("Авторизация валидный логин и пароль");
        authorizationPage.loginField.check(matches(isEnabled()));
        authorizationPage.loginField.perform(replaceText(TrueLogin));
        authorizationPage.passwordField.check(matches(isEnabled()));
        authorizationPage.passwordField.perform(replaceText(TruePassword));
        authorizationPage.signInButton.perform(click());
        mainSteps.mainPage();
    }

    public void emptyLoginAndPassword(){
        Allure.step("Пустой логин или пароль");
        onView(allOf(withContentDescription(EmptyLoginAndPassword), isDisplayed()));
    }

    public void errorLoginAndPassword(){
        Allure.step("Неверный логин или пароль");
        onView(allOf(withContentDescription(ErrorLoginAndPassword), isDisplayed()));
    }

   public void checkLogIn() {
       Allure.step("Вход в аккаунт");
        if (helper.LogIn()) {
           validAuthorization();
       }
    }
}



