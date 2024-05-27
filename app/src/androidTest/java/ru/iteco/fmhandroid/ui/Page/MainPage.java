
package ru.iteco.fmhandroid.ui.Page;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


public class MainPage {

    public ViewInteraction inRoot = onView(isRoot());
    public ViewInteraction menu = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction homePage = onView(withText(R.string.main));
    public ViewInteraction newsPage = onView(withId(R.id.news_list_swipe_refresh));
    public ViewInteraction aboutAppPage = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction person = onView(withId(R.id.authorization_image_button));
    public ViewInteraction logOut = onView((withText(R.string.log_out)));
    public ViewInteraction allNews = onView(withId(R.id.all_news_text_view));
    public ViewInteraction news = onView(withText(R.string.news));
    public ViewInteraction aboutApp = onView(withText(R.string.about));



}