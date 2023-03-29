package Pages.BookStorePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class WidgetsPage {

    private final SelenideElement widgetsHeader = $x("//div[@class=\"main-header\"][contains(text(),\"Widgets\")]");
    private final SelenideElement accordianLink = $x("//ul[@class=\"menu-list\"]//span[contains(text(),\"Accordian\")]");
    private final SelenideElement datePickerLink =  $x("//span[contains(text(),\"Date Picker\")]");;
    private final SelenideElement dateProgressBar =  $x("//span[contains(text(),\"Progress Bar\")]");
    private final SelenideElement toolTips =  $x("//span[contains(text(),\"Tool Tips\")]");
    private final SelenideElement selectMenu =  $x("//span[contains(text(),\"Select Menu\")]");

    public WidgetsPage() {
        $x("//div[@class=\"main-header\"][contains(text(),\"Widgets\")]").shouldHave(Condition.text("Widgets"));
    }

    public AccordianPage goToAccordianPage() {
        accordianLink.shouldBe(Condition.visible).click();
        return new AccordianPage();
    }

    public DatePicker goToDatePicker () {
        sleep(2000);
        datePickerLink.scrollTo();
        datePickerLink.shouldBe(Condition.visible).click();
        sleep(2000);
        return new DatePicker();
    }

    public ProgressBar goToProgressBar () {
        dateProgressBar.scrollTo().click();
        return new ProgressBar();
    }

    public ToolTipsPage goToToolTipPage () {
        toolTips.scrollTo().click();
        return new ToolTipsPage();
    }
    public SelectMenuPage goToSelectMenu () {
        selectMenu.scrollTo().click();
        return new SelectMenuPage();
    }
}
