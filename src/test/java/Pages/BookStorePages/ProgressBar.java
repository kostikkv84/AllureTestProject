package Pages.BookStorePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class ProgressBar {

    private SelenideElement progressBar = $x("//div[@role=\"progressbar\"]");
    private SelenideElement button = $("#startStopButton");
    public ProgressBar() {
        $x("//div[@class=\"main-header\"]").shouldHave(Condition.text("Progress bar"));
    }

    String status = "";
    public void start (){
       status = progressBar.getAttribute("style");
        System.out.println(status);
       button.shouldBe(exist).click();
       sleep(1500);
       button.shouldBe(exist).click();

        System.out.println(progressBar.getAttribute("style"));
        Assert.assertNotEquals(status, progressBar.getAttribute("style"));


    }



}
