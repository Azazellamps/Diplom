
package ru.iteco.fmhandroid.ui.Action;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

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
}
