package ru.iteco.fmhandroid.ui;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Elements;


public class PanelAction {
    public static void logOut() throws InterruptedException {
        Thread.sleep(5000);
        onView(withId(R.id.authorization_image_button)).perform(click());
        onView(allOf(withId(android.R.id.title),
                childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        0),
                isDisplayed())).perform(click());
                onView(withId(R.id.enter_button)).check(matches(isDisplayed()));
    }
    public static void newsBlock() {
        Elements.menuButton.perform(click());
        Elements.newsMenu.check(matches(isDisplayed()));
        Elements.newsMenu.perform(click());

    }

    public static void menuAboutTheApp() {
        Elements.menuButton.perform(click());
        Elements.aboutOfMenu.check(matches(isDisplayed()));
        Elements.aboutOfMenu.perform(click());
        Elements.versionValue.check(matches(isDisplayed()));

    }
    public static void menuHome() {
        Elements.menuButton.perform(click());
        Elements.homeMenu.check(matches(isDisplayed()));
        Elements.homeMenu.perform(click());

    }


    public static void checkButtonLogIn() {
        Elements.buttonLogIn.check(matches(isDisplayed()));
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