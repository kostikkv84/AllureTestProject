package Pages.BookStorePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegisterInBookStorePage {
    private final SelenideElement regLogin = $x("//input[@id='firstname']");
    private final SelenideElement regLastName = $x("//input[@id='lastname']");
    private final SelenideElement regUserName = $x("//input[@id='userName']");
    private final SelenideElement regPassword = $x("//input[@id='password']");
    private final SelenideElement regButton = $x("//button[@id='register']");
    private final SelenideElement regErrorCaptcha = $x("//p[@id='name']");


    public RegisterInBookStorePage register (String login, String lastName, String userName, String password) {
        regLogin.sendKeys(login);
        regLastName.sendKeys(lastName);
        regUserName.sendKeys(userName);
        regPassword.sendKeys(password);
        regButton.click();
        return this;
    }

    public String getErrorCaptcha(){
        return regErrorCaptcha.getText();
    }
}
