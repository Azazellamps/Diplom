
package ru.iteco.fmhandroid.ui.Action;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class Elements {
    public static ViewInteraction signInButton = onView(withId(R.id.enter_button));
    public static ViewInteraction loginField = onView(withId(R.id.login_text_input_layout));
    public static ViewInteraction passwordField = onView(withId(R.id.password_text_input_layout));
    public static ViewInteraction buttonLogIn = onView(withId(R.id.enter_button));
    public static ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction newsMenu = onView(withText("Новости"));
    public static ViewInteraction homeMenu = onView(withText("Главная"));
    public static ViewInteraction versionValue = onView(withText("1.0.0"));
    public static ViewInteraction aboutOfMenu = onView(withText("О приложении"));
    public static ViewInteraction privacyPolicyValue = onView(withText("https://vhospice.org/#/privacy-policy"));
    public static ViewInteraction termsOfUseValue = onView(withText("https://vhospice.org/#/terms-of-use"));
    public static ViewInteraction infoLabel = onView(withText("© Айтеко, 2022"));
    public static ViewInteraction filternews = onView(withText("Фильтровать новости"));

}