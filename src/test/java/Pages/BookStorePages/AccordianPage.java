package Pages.BookStorePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AccordianPage {

    private SelenideElement cardHeader1 = $("#section1Heading");
    private SelenideElement cardHeader2 = $("#section2Heading");
    private SelenideElement cardHeader3 = $("#section3Heading");

    private SelenideElement cardBody1 = $("#section1Content");
    private SelenideElement cardBody2 = $("#section2Content");
    private SelenideElement cardBody3 = $("#section3Content");

    private String text1 = "Lorem Ipsum is simply dummy text";
    private String text2 = "Contrary to popular belief";
    private String text3 = "It is a long established fact";
    public boolean cardHeaderChoise(SelenideElement header, SelenideElement content, String expected){
        header.scrollTo();
        header.click();
        return content.shouldHave(Condition.visible).getText().contains(expected);
    }


    public boolean getAccordionContentTest (String setText) {
        switch (setText) {
            case "Контент1":
                return cardHeaderChoise(cardHeader1, cardBody1, text1);
            case "Контент2":
                return cardHeaderChoise(cardHeader2, cardBody2, text2);
            case "Контент3":
                return cardHeaderChoise(cardHeader3, cardBody3, text3);
            default:
                return false;
        }
    }


    public AccordianPage cardHeaderClick() {
        $("#section1Heading").click();
        // cardHeader.forEach(x->x.click());
        sleep(1000);
        return this;
    }


}
