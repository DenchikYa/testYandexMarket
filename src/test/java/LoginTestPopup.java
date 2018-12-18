import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.WebDriverLoader;

public class LoginTestPopup {


    private static final int TIMEOUT_SEC = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeTest
    public void init(ITestContext testContext)
    {
        driver = WebDriverLoader.setDriver();
        wait = WebDriverLoader.setWait(driver, TIMEOUT_SEC);
        testContext.setAttribute("WebDriver", this.driver);
    }

    @Description("Test for login popup")
    @Test(groups = { "basic" })
    public void loginTest(){
        WebDriverLoader.loadPage(driver, PAGENAME);

        String login = CheckLoginPopup.login(wait, driver);
        Assert.assertEquals(CheckLoginPopup.getUserName(wait), login);
    }

    @AfterTest(alwaysRun=true)
    public void closeBrowser()
    {
        driver.close();
    }
}
