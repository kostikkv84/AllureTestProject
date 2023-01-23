package Pages.BookStorePages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginInBookStorePage {
    private final SelenideElement newUserButton = $x("//button[@id='newUser']");
    private final SelenideElement userNameInput = $x("//input[@id='userName']");
    private final SelenideElement passwordInput = $x("//input[@id='password']");
    private final SelenideElement loginButton = $x("//button[@id='login']");
    private final SelenideElement logoutButton = $x("//button[@id='submit']");

    public RegisterInBookStorePage newUser() {
        newUserButton.click();
        return new RegisterInBookStorePage();
    }

    public LoginInBookStorePage login (String userName, String password){
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }

    public String getLogOutButton() {
        return logoutButton.getText();
    }


}
