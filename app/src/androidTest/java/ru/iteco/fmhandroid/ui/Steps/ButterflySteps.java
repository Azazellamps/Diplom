package ru.iteco.fmhandroid.ui.Steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Page.ButterflyPage;

public class ButterflySteps {
    ButterflyPage butterflyPage = new ButterflyPage();

    public void clickButterflyButton() {
        Allure.step("Клик по кнопке бабочка");
        butterflyPage.butterflyButton.perform(click());;
    }

    public void elementQuote() {
        Allure.step("Проверка элементов на странице цитаты");
        butterflyPage.liveLove.check(matches(isDisplayed()));
        butterflyPage.butterflyQuotes.check(matches(isDisplayed()));
    }

    public void expandQuote(int number) {
        Allure.step("Развернуть/свернуть цитату");
        butterflyPage.butterflyList.check(matches(isDisplayed()));
        butterflyPage.butterflyList.perform(actionOnItemAtPosition(number, click()));
    }


    public void descriptionQuote(String text) {
        Allure.step("Отображение дополнительной цитаты");
        onView(allOf(
                withId(R.id.our_mission_item_description_text_view),
                withText(text),
                isCompletelyDisplayed()))
                .check(matches(isDisplayed()));
    }
}

