package ru.iteco.fmhandroid.ui.Action;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import ru.iteco.fmhandroid.R;


public class HomePageAction {

    public static void homePageNews() {
        onView(allOf(withText("Новости"),
                withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main))),
                isDisplayed())).check(matches(withText("Новости")));

    }

    public static void arrowExpandNewsButton() {
        onView(allOf(withId(R.id.all_news_text_view), withText("ВСЕ НОВОСТИ"),
                withParent(allOf(withId(R.id.container_list_news_include_on_fragment_main),
                        withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                isDisplayed())).check(matches(withText("ВСЕ НОВОСТИ")));
        onView(allOf(withId(R.id.expand_material_button),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.container_list_news_include_on_fragment_main),
                                0),
                        4),
                isDisplayed())).perform(click());
        onView(allOf(withId(R.id.all_news_text_view), withText("ВСЕ НОВОСТИ"),
                withParent(allOf(withId(R.id.container_list_news_include_on_fragment_main),
                        withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                isDisplayed())).check(doesNotExist());
    }
    public static void arrowNewsFromTheList() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_news_cards_block_constraint_layout),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

    }




    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
