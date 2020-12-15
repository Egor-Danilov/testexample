package eadanilov.tests;

import eadanilov.CardData;
import eadanilov.conf.ConfProperties;
import eadanilov.pages.AuthPage;
import eadanilov.pages.BillingPage;
import eadanilov.pages.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static eadanilov.conf.ConfProperties.getProperty;
import static org.hamcrest.MatcherAssert.assertThat;

class UpdatingAccountTest {
    private static WebDriver driver;
    private static DashboardPage dashboardPage;
    private static BillingPage billingPage;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        AuthPage authPage = new AuthPage(driver);
        driver.get(ConfProperties.getProperty("loginPageUrl"));
        authPage.signIn(getProperty("login"), getProperty("password"));
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void checkTotalPriseFieldTest() {
        String yearlyTotalPrise = "192";
        String monthlyTotalPrise = "20";
        dashboardPage = new DashboardPage(driver);
        billingPage = new BillingPage(driver);

        assertThat("Сheck that the main page has loaded",
                dashboardPage.page.isDisplayed());

        dashboardPage.clickUpgrateButton();
        billingPage.selectTeamPlan();
        billingPage.selectTwoMembers();

        assertThat("Check that the plan for the year is selected",
                billingPage.yearlyBillingType.isEnabled());
        assertThat("Checking that the total amount for the yearly plan is correct",
                billingPage.totalPrice.getText().contains(yearlyTotalPrise));

        billingPage.selectMonthlyBillingType();

        assertThat("Checking that the total amount for the monthly plan is correct",
                billingPage.totalPrice.getText().equals(monthlyTotalPrise));
    }

    @ParameterizedTest
    @EnumSource(CardData.class)
    void checkErrorMessageToIncorrectBindingData(CardData cardData) {
        dashboardPage = new DashboardPage(driver);
        billingPage = new BillingPage(driver);

        assertThat("Сheck that the main page has loaded",
                dashboardPage.page.isDisplayed());

        dashboardPage.clickUpgrateButton();
        billingPage.selectTeamPlan();
        billingPage.setCardDataField(cardData, driver);

        assertThat("Checking the error message",
                billingPage.errorField.getText().equals(cardData.getErrorMessage()));
    }
}