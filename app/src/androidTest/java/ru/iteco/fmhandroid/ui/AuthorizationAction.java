package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class AuthorizationAction {

    public static void loginPersonalAccount(String login, String password) throws InterruptedException {
        Thread.sleep(5000);
        Elements.loginField.perform(click());
        onView(allOf(childAtPosition(
                childAtPosition(
                        withId(R.id.login_text_input_layout),
                        0),
                0),
                isDisplayed())).perform(replaceText(login));
        Elements.passwordField.perform(click());
        onView(allOf(childAtPosition(
                childAtPosition(
                        withId(R.id.password_text_input_layout),
                        0),
                0),
                isDisplayed())).perform(replaceText(password));
        Elements.signInButton.perform(click());
    }


    public static void buttonAuthorization() throws InterruptedException {
        Thread.sleep(3000);
        Elements.signInButton.perform(click());
    }


    public static void textAuthorization() throws InterruptedException {
        Thread.sleep(3000);
        onView(allOf(withText("Авторизация"),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed())).check(matches(withText("Авторизация")));
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
