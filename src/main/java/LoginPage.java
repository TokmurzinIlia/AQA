import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement loginField = $(By.id("user-name"));
    SelenideElement passwordField = $(By.id("password"));
    SelenideElement signInButton = $(By.id("login-button"));

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Step("Login")
    public void login() {

        loginField.sendKeys(USERNAME);
        passwordField.sendKeys(PASSWORD);
        signInButton.click();
    }
    @Step("Open Login Page")
    public void openLoginPage(){

        open("https://www.saucedemo.com/");

    }
}
