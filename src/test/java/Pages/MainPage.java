package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    SelenideElement mainPageHeader = $x("//div[@id=\"content\"]/h1[contains(text(),\"Welcome to the-internet\")]");

    public MainPage (String url){
        Selenide.open(url);
    }

    public String checkMainPageHeader(){
        return mainPageHeader.getText();
    }

}
