
package ru.iteco.fmhandroid.ui.Action;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class AboutAppAction {

    public static void readAppPage() {
        Elements.versionValue.check(matches(isDisplayed()));
        Elements.privacyPolicyValue.check(matches(isDisplayed()));
        Elements.termsOfUseValue.check(matches(isDisplayed()));
        Elements.infoLabel.check(matches(isDisplayed()));

    }

    public static void goToPrivacyPolicy() {
        Elements.privacyPolicyValue.perform(click());
    }

    public static void goToTermsOfUse() {
        Elements.termsOfUseValue.perform(click());
    }

    public static void checkPrivacyPolicy() {
        intended(allOf(
                hasData("https://vhospice.org/#/privacy-policy"),
                hasAction(Intent.ACTION_VIEW)
        ));
    }

    public static void checkTermsOfUse() {
        intended(allOf(
                hasData("https://vhospice.org/#/terms-of-use"),
                hasAction(Intent.ACTION_VIEW)
        ));

    }
    public static void returnButton() throws InterruptedException {
        Thread.sleep(3000);
    ViewInteraction appCompatImageButton2 = onView(
            allOf(withId(R.id.about_back_image_button),
                    childAtPosition(
                            allOf(withId(R.id.container_custom_app_bar_include_on_fragment_about),
                                    childAtPosition(
                                            withClassName(is("android.widget.LinearLayout")),
                                            0)),
                            1),
                    isDisplayed()));
        appCompatImageButton2.perform(

    click());

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
