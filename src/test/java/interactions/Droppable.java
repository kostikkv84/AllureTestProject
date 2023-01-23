package interactions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class Droppable {
    private final SelenideElement header = $x("//div[@class=\"main-header\"][contains(text(), \"Droppable\")]");
    private final SelenideElement dragElem = $x("//div[@id=\"draggable\"]");
    private final SelenideElement dropElem = $x("//div[@id=\"droppable\"]");

    public Droppable() {
        Selenide.open("/droppable");
    }

    public void dragNDropElem() {
        actions().moveToElement(dragElem).clickAndHold().moveToElement(dropElem).release().build().perform();
    }

    public String getAttributeDropElem () {
       return dropElem.getAttribute("class");
    }
}
