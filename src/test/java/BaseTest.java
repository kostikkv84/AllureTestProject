import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;

public class BaseTest {


    public void setUp(){
        WebDriverManager.chromedriver().setup();
      //  Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless =false;
    }
    @Before
    public void init() {setUp();}
    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}