package interactions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Sortable {

    private final SelenideElement elem1 = $x("//div[contains(text(),'One')]");
    private final SelenideElement elem2 = $x("//div[contains(text(),'Four')]");
    private final SelenideElement elem3 = $x("//div[@class=\"create-grid\"]//div[@style][1]");
    private final SelenideElement elem4 = $x("//div[@class=\"create-grid\"]//div[@style][7]");

    /**
     * Конструктор
     */
    public Sortable() {
        sortableMenu().should(Condition.exist);
    }

    public SelenideElement sortableHeader() {
        return $x("//div[@class='main-header'][contains(text(),'Interactions')]");
    }

    private SelenideElement sortableMenu() {
        return $x("//span[contains(text(),\"Sortable\")]");
    }

    public ElementsCollection list() {
        return $$x("//div[@class='list-group-item list-group-item-action']");
    }

    public ElementsCollection grid() {
        return $$x("//div[@class=\"create-grid\"]//div[@style]");
    }

    //------------------------------------------------------------------------------------------------------------


    public List<String> getCollectionList() {
        List<String> listText = new ArrayList<>();
        list().forEach(x -> listText.add(x.getText())); // создаем список из текста элементов.
        System.out.println(listText);
        return listText;
    }
    public List<String> getCollectionGrid() {
        List<String> gridText = new ArrayList<>();
        grid().forEach(x -> gridText.add(x.getText())); // создаем список из текста элементов.
        System.out.println(gridText);
        return gridText;
    }

    public Sortable sortList() {
        actions().moveToElement(elem1).clickAndHold().moveToElement(elem2).release().build().perform();
        return this;
    }

    public Sortable sortGrid() {
        elem3.dragAndDropTo(elem4);
        //actions().clickAndHold(elem3).moveToElement(elem4).release().build().perform();
        return this;
    }

    public Sortable openListTab() {
        $x("//a[@id='demo-tab-list']").click();
        return this;
    }

    public Sortable openGridTab() {
        $x("//a[@id='demo-tab-grid']").click();
        return this;
    }



    public Sortable openSortable() {
        sortableMenu().scrollTo().click();
        return  new Sortable();
    }

}
