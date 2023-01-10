
import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.PrimitiveIterator;


public class TestCreate extends BaseTest{
    private final static String BASE_URL = "https://the-internet.herokuapp.com/";

    @Test
    @DisplayName("Check report allure")
    public void checkHref() {
        int i = 1;
        Assert.assertEquals(1,i);
    }

    @Test
    public void checkMainPageHeader(){
        MainPage mainPage = new MainPage(BASE_URL);
        Assert.assertEquals("Welcome to the-internet",mainPage.checkMainPageHeader());
    }
}
