package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BooksStorePage {
    private final SelenideElement login = $x("//button[@id='login']");

    public LoginInBookStorePage loginInToBookStore() {
        login.click();
        return new LoginInBookStorePage();
    }
}
