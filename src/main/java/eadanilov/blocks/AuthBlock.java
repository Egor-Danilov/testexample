package eadanilov.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AuthBlock {
    @FindBy(xpath = ".//*[@data-autotest-id='mr-form-login-email-1']")
    public WebElement loginField;
    @FindBy(xpath = ".//*[@data-autotest-id='mr-form-login-password-1']")
    public WebElement passwordField;
    @FindBy(xpath = ".//*[@data-autotest-id='mr-form-login-btn-signin-1']")
    public WebElement loginButton;

    public AuthBlock(WebDriver driver) {
        initElements(driver, this);
    }
}
