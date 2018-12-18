import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GlobalMethods;
import utils.WebDriverLoader;

import java.io.IOException;
import java.util.List;

public class SearchMousePageTest {

    private static final int TIMEOUT_SEC = 10;
    private static final String SITE_URL = "https://market.yandex.ru/";
    private static final String QUERY = "Компьютерные мыши";
    private static final String MIN_PRICE = "800";
    private static final String MAX_PRICE = "1000";

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeTest
    public void init(ITestContext testContext)
    {
        driver = WebDriverLoader.setDriver();
        wait = WebDriverLoader.setWait(driver, TIMEOUT_SEC);
        testContext.setAttribute("WebDriver", this.driver);
    }

    @Description("Test finds mouses in set range.")
    @Test(groups = { "basic" })
    public void checkMousePrice() throws IOException {
        WebDriverLoader.loadPage(driver, SITE_URL);

        GlobalMethods.searchField(wait, QUERY);
        GlobalMethods.MinPriceField(wait, MIN_PRICE);
        GlobalMethods.MaxPriceField(wait, MAX_PRICE);

        List<String> temp = SearchMousePage.getMousesForPage(wait);

        for (String itemPrice : temp) {
            if (Integer.parseInt(itemPrice) < Integer.parseInt(MIN_PRICE)
                    && Integer.parseInt(itemPrice) > Integer.parseInt(MAX_PRICE)) {
                Assert.fail("Found products with inappropriate price");
            }
        }


    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }
}
