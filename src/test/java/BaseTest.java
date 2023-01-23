import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    final static String BASE_USER_NAME = "JohnConnor";
    final static String BASE_FIRST_NAME = "Vasiliy";
    final static String BASE_LAST_NAME = "Moskovskiy";
    final static String BASE_PASSWORD = "P@ssw0rd";


    public void setUp(){
       /* Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl="https://demoqa.com/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo",true);
        Configuration.browserCapabilities = capabilities; */

       WebDriverManager.firefoxdriver().setup();
       // Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browser = "firefox";
        Configuration.driverManagerEnabled = true;
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize = "1600x950";
        Configuration.headless =false;
    }
    @Before
    public void init() {setUp();}

   @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
    public void delay(Integer timeToDelay){
        try {
            Thread.sleep(timeToDelay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
