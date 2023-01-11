import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    final static String BASE_USER_NAME = "JohnConnor";
    final static String BASE_FIRST_NAME = "Vasiliy";
    final static String BASE_LAST_NAME = "Moskovskiy";
    final static String BASE_PASSWORD = "P@ssw0rd";


    public void setUp(){
        WebDriverManager.chromedriver().setup();
       // Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1600x950";
        Configuration.headless =false;
    }
    @Before
    public void init() {setUp();}
 /*   @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }*/
}
