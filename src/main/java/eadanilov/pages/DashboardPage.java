package eadanilov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class DashboardPage {
    @FindBy(xpath = ".//*[@data-autotest-id='dashboard__content']")
    public WebElement page;
    @FindBy(xpath = "//button[contains(text(),'Upgrade')]")
    private WebElement upgrateButton;


    public DashboardPage(WebDriver driver) {
        initElements(driver, this);
        driver.get("https://miro.com/app/dashboard/");
    }

    public void clickUpgrateButton() {
        upgrateButton.click();
    }
}
