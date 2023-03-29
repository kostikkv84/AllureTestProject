package Pages.BookStorePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ToolTipsPage {

    private final SelenideElement button = $("#toolTipButton");
    private final SelenideElement input = $("#toolTipTextField");
    public ToolTipsPage() {
        $x("//div[@class=\"main-header\"]").shouldHave(Condition.text("Tool Tips"));
    }

    public void buttonHover() {
        //actions().moveToElement(button).clickAndHold(button).build();
        button.scrollTo();
        button.hover().shouldHave(Condition.attribute("aria-describedby")).getText();

        System.out.println(button.getAttribute("aria-describedby"));
        System.out.println(button.getText());
        sleep(3000);
    }

    public void inputHover () {
        input.hover().shouldHave(Condition.attribute("aria-describedby"));

    }
}
