package Pages.BookStorePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SelectMenuPage {

    private final SelenideElement selectValue = $x("//div[contains(text(),\"Select Option\")]");

    public SelectMenuPage() {
        $(".main-header").shouldHave(Condition.text("Select Menu"));
    }

    public void selectValue () {
        selectValue.click();
        sleep(5000);
    }

}
