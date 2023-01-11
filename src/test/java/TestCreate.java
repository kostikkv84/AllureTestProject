

import Pages.BooksStorePage;
import Pages.LoginInBookStorePage;
import Pages.MainPage;
import Pages.RegisterInBookStorePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import java.security.PublicKey;
import java.util.PrimitiveIterator;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestCreate extends BaseTest{
    private final static String BASE_URL = "https://demoqa.com/";

    @Test
    @DisplayName("Check report allure")
    public void baseCheckTestProject() {
        int i = 1;
        Assert.assertEquals(1,i);
    }

    @Test
    public void checkMainPageHeader(){
        MainPage mainPage = new MainPage(BASE_URL);
        Assert.assertEquals("Selenium Online Training",mainPage.checkMainPageHeader());
    }

    /**
     * Проверка отображения необходимости верифицировать captcha при регистрации
     */
    @Test
    public void checkCaptchaError() {
        Assert.assertTrue(new MainPage(BASE_URL).
                goToBookStore().
                loginInToBookStore().
                newUser().
                register(BASE_FIRST_NAME, BASE_LAST_NAME, BASE_USER_NAME, BASE_PASSWORD).
                getErrorCaptcha().
                contains("Please verify reCaptcha to register!"));
    }

    @Test
    public void loginBookStore () {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.goToBookStore();
        BooksStorePage booksStorePage = new BooksStorePage();
        booksStorePage.loginInToBookStore();
        LoginInBookStorePage loginInBookStorePage = new LoginInBookStorePage();
        loginInBookStorePage.login(BASE_USER_NAME,BASE_PASSWORD);

        int i =0;

   /*     Assert.assertTrue(new MainPage(BASE_URL)
                .goToBookStore()
                .loginInToBookStore()
                .login(BASE_USER_NAME,BASE_PASSWORD)
                .getLogOutButton()
                .contains("Log out"));  */
    }

   /* @Test
    public void loginBookStore() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.goToBookStore();
        BooksStorePage booksStorePage = new BooksStorePage();
        booksStorePage.loginInToBookStore();

    }*/

}
