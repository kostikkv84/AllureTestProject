package Pages.BookStorePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SelectMenuPage {

    private final SelenideElement selectValue = $(". css-1wa3eu0-placeholder");

    public SelectMenuPage() {
        $(".main-header").shouldHave(Condition.text("Select Menu"));
    }

    public void selectValue () {
        selectValue.click();
        sleep(5000);
    }

}
