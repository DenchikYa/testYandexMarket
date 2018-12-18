import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class VacuumCleanerSearchPage {


    public static void clickToCleaner(WebDriverWait wait, WebDriver driver) {
        WebElement cleaner = driver.findElement(By.linkText("Пылесос Xiaomi Mi Robot Vacuum Cleaner"));
        cleaner.click();
    }

    public static void addToBasket(WebDriverWait wait, WebDriver driver) {
        WebElement addToBasket = driver.findElement
                (By.cssSelector("span.n-product-toolbar__item-label.n-product-toolbar__item-label_activated_no"));
        addToBasket.click();
    }

    public static void goToBasket(WebDriverWait wait, WebDriver driver) {
        WebElement tmp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Перейти к отложенным")));
        tmp.click();
    }
}
