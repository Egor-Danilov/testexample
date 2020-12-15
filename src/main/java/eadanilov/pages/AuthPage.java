package eadanilov.pages;

import eadanilov.blocks.AuthBlock;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AuthPage {
    private AuthBlock authBlock;

    public AuthPage(WebDriver driver) {
        initElements(driver, this);
        authBlock = new AuthBlock(driver);
    }

    public void signIn(String login, String passwd) {
        authBlock.loginField.sendKeys(login);
        authBlock.passwordField.sendKeys(passwd);
        authBlock.loginButton.click();
    }

}
