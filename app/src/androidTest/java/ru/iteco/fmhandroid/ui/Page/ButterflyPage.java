package ru.iteco.fmhandroid.ui.Page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.Data.Helper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class ButterflyPage {

    public ViewInteraction butterflyButton = onView((withId(R.id.our_mission_image_button)));
    public ViewInteraction liveLove = onView((withId(R.id.our_mission_title_text_view)));
    public ViewInteraction butterflyQuotes = onView(withId(R.id.our_mission_item_list_recycler_view));
    public ViewInteraction butterflyList = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
}