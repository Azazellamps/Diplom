package ru.iteco.fmhandroid.ui.Page;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.AllOf.allOf;

public class AuthorizationPage {

    public ViewInteraction authorization = onView(allOf(withText("Авторизация"), withParent(withParent(withId(R.id.nav_host_fragment)))));
    public ViewInteraction loginField = onView(allOf(withHint(R.string.login), withParent(withParent(withId(R.id.login_text_input_layout)))));
    public ViewInteraction passwordField = onView(allOf(withHint(R.string.password), withParent(withParent(withId(R.id.password_text_input_layout)))));
    public ViewInteraction signInButton = onView(allOf(withId(R.id.enter_button)));
    public ViewInteraction inRoot = onView(isRoot());
    public int signInButtonId = R.id.enter_button;
    public static final String TrueLogin = "login2";
    public static final String TruePassword = "password2";
    public static final String IncorrectLogin = "login3";
    public static final String IncorrectPassword = "password3";
    public static final String SymbolsLogin = "login3!!!$$$";
    public static final String SymbolsPassword = "password3!!!$$$";
    public static final String EmptyLoginAndPassword = "Логин и пароль не могут быть пустыми";
    public static final String ErrorLoginAndPassword = "Что-то пошло не так. Попробуйте позднее.";
}



