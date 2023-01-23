package interactions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class Resizable {
    private final SelenideElement header = $x("//div[@class=\"main-header\"][contains(text(), \"Resizable\")]");
    private final SelenideElement resizableElem1 = $x("//div[@id=\"resizableBoxWithRestriction\"]");
    private final SelenideElement dragElem = $x("//div[@id=\"resizableBoxWithRestriction\"]//span");
    public Resizable() {
        Selenide.open("/resizable");
        header.shouldBe(Condition.visible);
    }

    public void resize1 () {
        actions().dragAndDropBy(dragElem, 100, -50).perform();
    }

    public String getStyle () {
        return resizableElem1.getAttribute("Style");
    }
}
