package ru.iteco.fmhandroid.ui.Steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.Page.MainPage;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.Data.Helper.waitDisplayed;


public class MainSteps {
    MainPage mainPage = new MainPage();
    AuthorizationPage  authorizationPage = new AuthorizationPage();

    public void mainPage(){
        Allure.step("Главная страница");
        mainPage.inRoot.perform(waitDisplayed(R.id.all_news_text_view, 5000));
        mainPage.allNews.check(matches(isDisplayed()));
    }

    public void checkAllNews(){
        Allure.step("Переход на страницу ВСЕ НОВОСТИ");
        mainPage.allNews.perform(click());
        mainPage.newsPage.check(matches(isDisplayed()));
    }

    public void checkMenuNews() {
        Allure.step("Главное меню. Раздел Новости");
        mainPage.menu.perform(click());
        mainPage.news.perform(click());
        mainPage.newsPage.check(matches(isDisplayed()));
    }

    public void checkMenuAboutApp() {
        Allure.step("Главное меню. Раздел О приложении");
        mainPage.menu.perform(click());
        mainPage.aboutApp.perform(click());
        mainPage.aboutAppPage.check(matches(isDisplayed()));
    }

    public void checkHomePage() {
        Allure.step("Гланое меню. Раздел Главная из раздела Новости");
        mainPage.menu.perform(click());
        mainPage.news.perform(click());
        mainPage.menu.perform(click());
        mainPage.homePage.perform(click());
        mainPage.allNews.check(matches(isDisplayed()));
    }
    public void logOut() {
        Allure.step("Выход из аккаунта");
        mainPage.person.perform(click());
        mainPage.logOut.perform(click());
        authorizationPage.authorization.check(matches(isDisplayed()));
    }
}
