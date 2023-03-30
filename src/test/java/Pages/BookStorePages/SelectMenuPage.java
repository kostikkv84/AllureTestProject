package Pages.BookStorePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SelectMenuPage {

    private final SelenideElement selectValue = $x("//div[contains(text(),\"Select Option\")]");
    private final SelenideElement rootOption = $x("//div[contains(text(),\"A root option\")]");
    private final SelenideElement selectTitle = $x("//div[contains(text(),\"Select Title\")]");
    private final SelenideElement selectProf = $("#react-select-3-option-0-4");
    private final SelenideElement oldStyleSelecteMenu = $("#oldSelectMenu");
    private final SelenideElement optionPurple = $x("//option[@value=\"4\"]");
    private final SelenideElement multiselectMenu = $x("//div[contains(text(),\"Select...\")]");
    private final SelenideElement multiselectSelect = $("#react-select-4-option-1");

    public SelectMenuPage() {
        $(".main-header").shouldHave(Condition.text("Select Menu"));
    }

    public void selectValue () {
        selectValue.shouldBe(Condition.visible).click();
        rootOption.shouldBe(Condition.visible).click();
        selectTitle.shouldBe(Condition.visible).click();
        selectProf.shouldBe(Condition.visible).click();

        oldStyleSelecteMenu.shouldBe(Condition.visible).click();
        optionPurple.shouldBe(Condition.visible).click();
        multiselectMenu.shouldBe(Condition.visible).click();
        multiselectSelect.shouldBe(Condition.visible).click();

        sleep(5000);
    }

}
