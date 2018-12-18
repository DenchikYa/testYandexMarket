import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalMethods;
import utils.WebDriverLoader;

public class VacuumCleanerPageTest {

    private static final int TIMEOUTSECONDS = 40;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static final String QUERY_PRODUCT = "Пылесос робот с управлением со смартфона";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeTest
    public void init(ITestContext testContext)
    {
        driver = WebDriverLoader.setDriver();
        wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);
        testContext.setAttribute("WebDriver", this.driver);
    }

    @Description("Adding to the basket cleaner.")
    @Test(groups = {"Adding_to_basket"})
    public void addToBasket() {
        WebDriverLoader.loadPage(driver, PAGENAME);
        String login = CheckLoginPopup.login(wait, driver);
        Assert.assertEquals(CheckLoginPopup.getUserName(wait), login);
        GlobalMethods.searchField(wait, QUERY_PRODUCT);
        VacuumCleanerSearchPage.clickToCleaner(wait, driver);
        VacuumCleanerSearchPage.addToBasket(wait, driver);
        VacuumCleanerSearchPage.goToBasket(wait, driver);
    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }


}
