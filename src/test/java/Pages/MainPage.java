package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement mainPageHeader = $x("//div[@class=\"home-banner\"]//a/img");
    private final SelenideElement bookStoreCard = $x("//h5[contains(text(),\"Book Store Application\")]//parent::div");



    public MainPage (String url){
        Selenide.open(url);
    }

    public String checkMainPageHeader(){
        return mainPageHeader.getAttribute("alt");
    }

    public BooksStorePage goToBookStore() {
        bookStoreCard.scrollTo().click();
        return new BooksStorePage();
    }



}
