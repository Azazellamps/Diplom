import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.AuthorizationAction;
import ru.iteco.fmhandroid.ui.NewsAction;
import ru.iteco.fmhandroid.ui.NewsEditingAction;
import ru.iteco.fmhandroid.ui.PanelAction;



import androidx.test.rule.ActivityTestRule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(AllureAndroidJUnit4.class)

public class NewsTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);
    String TrueLogin = "login2";
    String TruePassword = "password2";

    @Test
    @DisplayName("Создание новости с валидными значениями")
    public void aRealTimeTest() throws InterruptedException {
        AuthorizationAction.loginPersonalAccount(TrueLogin, TruePassword);
        PanelAction.checkButtonLogIn();
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.newsRealTime();
    }

    @Test
    @DisplayName("Создание пустой новости")
    public void emptyNewsTest() throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.creatingAnEmptyNews();
    }

    @Test
    @DisplayName("Создание новости с публикацией через год")
    public void publicationForNextYear() throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.publicationForNextYear();
    }

    @Test
    @DisplayName("Фильтрация новостей.Валидные данные")
    public void filterNewsRealTime() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsAction.filterRealTime();
    }

    @Test
    @DisplayName("Кнопка сортировки новостей")
    public void sortNewsTest() throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
    }

        @Test
    @DisplayName("Кнопка фильтр новостей")
    public void filterButtonNews() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsAction.filterButtonNews();
        NewsAction.filterForm();

    }

    @Test
    @DisplayName("Пустой фильтр")
    public void filterEmpty() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsAction.filterEmpty();
    }

    @Test
    @DisplayName("Отменить фильтрацию")
    public void filterСancel() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsAction.filterCancel();
    }

    @Test
    @DisplayName("Новая категория")
    public void newCategoryFilter() throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.nonExistentCategory();
    }

    @Test
    @DisplayName("Панель управления. Фильтр нажать кнопку не активна")
    public void filterButtonIsNotActive() throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.filterButtonIsNotActive();
    }

    @Test
    @DisplayName("Создание новости публикация через месяц")
    public void newsMonth () throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.publicationInAMonth();
    }
    @Test
    @DisplayName("Создание новости отмена")
    public void newsCancel() throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.newsCancel();


    }

    @Test
    @DisplayName("Создание новости.Новая категория")
    public void newCategoryNews() throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.newCategoryNews();

    }
    @Test
    @DisplayName("Сортировать новости панель управления")
    public void controlPanelSort() throws InterruptedException {
        Thread.sleep(3000);
        NewsAction.allNews();
        NewsAction.controlPanelSortNews();

    }
            @Test
    @DisplayName("Кнопка фильтр новостей панель управления")
    public void filterButtonControlPanel() throws InterruptedException {
        Thread.sleep(5000);
        NewsAction.allNews();
        NewsAction.filterButtonControlPanel();
        NewsAction.filterForm();

    }

}



