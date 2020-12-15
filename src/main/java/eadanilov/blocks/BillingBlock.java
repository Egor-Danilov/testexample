package eadanilov.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BillingBlock {
    @FindBy(xpath = ".//*[@data-elements-stable-field-name='cardNumber']")
    public WebElement cardNumberField;
    @FindBy(xpath = ".//*[@data-elements-stable-field-name='cardExpiry']")
    public WebElement expiryField;
    @FindBy(xpath = ".//*[@data-elements-stable-field-name='cardCvc']")
    public WebElement cvcField;
    @FindBy(xpath = ".//*[@data-autotest-id='choose-plan-modal__upgrade-button']")
    public WebElement selectTeamPlan;
    @FindBy(xpath = ".//*[@data-autotest-id='plan-change-modal__team-size-select']")
    public WebElement chooseTeam;
    @FindBy(xpath = ".//*[@class='rtb-select__option rtb-select__option--focused']")
    public WebElement twoMembers;
    @FindBy(xpath = ".//*[@data-autotest-id='plan-change-modal__interval-button-month']")
    public WebElement monthBillingType;

    public BillingBlock(WebDriver driver) {
        initElements(driver, this);
    }
}
