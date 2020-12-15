package eadanilov.pages;

import eadanilov.CardData;
import eadanilov.blocks.BillingBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BillingPage {
    @FindBy(xpath = ".//*[@data-autotest-id='stripe-token-card-input__card-error']")
    public WebElement errorField;
    @FindBy(xpath = ".//*[@data-autotest-id='plan-change-modal__total-sum']")
    public WebElement totalPrice;
    @FindBy(xpath = ".//*[@data-autotest-id='plan-change-modal__interval-button-year']")
    public WebElement yearlyBillingType;
    private BillingBlock billingBlock;


    public BillingPage(WebDriver driver) {
        initElements(driver, this);
        billingBlock = new BillingBlock(driver);
    }

    public void selectTeamPlan() {
        billingBlock.selectTeamPlan.click();
    }

    public void selectTwoMembers() {
        billingBlock.chooseTeam.click();
        billingBlock.twoMembers.click();
    }

    public void selectMonthlyBillingType() {
        billingBlock.monthBillingType.click();
    }

    public void setCardDataField(CardData cardData, WebDriver driver) {
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Защищенное окно для ввода данных оплаты картой']")));
        billingBlock.cardNumberField.sendKeys(cardData.getPan());
        billingBlock.expiryField.sendKeys(cardData.getExpire());
        billingBlock.cvcField.sendKeys(cardData.getCvc());
        driver.switchTo().defaultContent();
    }
}
