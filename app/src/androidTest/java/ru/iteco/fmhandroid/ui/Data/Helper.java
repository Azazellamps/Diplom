package ru.iteco.fmhandroid.ui.Data;
import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.concurrent.TimeoutException;

import ru.iteco.fmhandroid.ui.Page.AuthorizationPage;


public class Helper {

    AuthorizationPage authorizationPage = new AuthorizationPage();



    public boolean LogIn() {
        boolean check = false;
        try {
            waitElement(authorizationPage.signInButtonId);
            authorizationPage.loginField.check(matches(isDisplayed()));
            check = true;
            return check;
        } catch (NoMatchingViewException e) {
            check = false;
            return check;
        } finally {
            return check;
        }
    }

    public static Matcher < View > childAtPosition(
            final Matcher < View > parentMatcher, final int position) {

        return new TypeSafeMatcher < View > () {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent) &&
                        view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }


    public static Matcher < View > childAtPosition(Matcher < View > matcher, final Matcher < View > parentMatcher, final int position) {

        return new TypeSafeMatcher < View > () {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent) &&
                        view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public static void waitElement(int id) {
        onView(isRoot()).perform(waitDisplayed(id, 5000));
    }
    public static Matcher < View > withIndex(final Matcher < View > matcher, final int index) {
        return new TypeSafeMatcher < View > () {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }
    public static ViewAction waitDisplayed(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher < View > getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> is shown during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher < View > viewMatcher = withId(viewId);

                do {
                    for (View child: TreeIterables.breadthFirstViewTraversal(view)) {
                        if (viewMatcher.matches(child) && child.isShown()) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }
}