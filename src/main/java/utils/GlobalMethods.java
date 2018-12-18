package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GlobalMethods {

    private static final String SEARCH_FIELD = "header-search";
    private static final String SEARCH_BUTTON = "button.button2";
    private static final String MIN_PRICE = "#glpricefrom";
    private static final String MAX_PRICE = "#glpriceto";

    public static void searchField(WebDriverWait wait, String queryProduct) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SEARCH_FIELD)));
        searchField.clear();
        searchField.sendKeys(queryProduct);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SEARCH_BUTTON)));
        searchButton.click();
    }

    public static void MinPriceField(WebDriverWait wait, String minPriceValue) {
        WebElement minPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MIN_PRICE)));
        minPrice.clear();
        minPrice.sendKeys(minPriceValue);
    }

    public static void MaxPriceField(WebDriverWait wait, String maxPriceValue) {
        WebElement maxPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MAX_PRICE)));
        maxPrice.clear();
        maxPrice.sendKeys(maxPriceValue);
    }

    public static WebElement clickElemBySelect(WebDriverWait wait, String inf) {
        WebElement tmp = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(inf)));
        tmp.click();
        return  tmp;
    }

    public static WebElement clickElemById(WebDriverWait wait, String inf) {
        WebElement tmp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inf)));
        tmp.click();
        return  tmp;
    }

    public static WebElement clickElemByXPath(WebDriverWait wait, String inf) {
        WebElement tmp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inf)));
        tmp.click();
        return  tmp;
    }

    public static String  getTextOfField(WebDriverWait wait, String inf) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(inf))).getText();
    }

    public static void  sendKeysBySelect(WebDriverWait wait, String pattern, String keys) {
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pattern)));
        login.clear();
        login.sendKeys(keys);
    }
    public static void  sendKeysByXPath(WebDriverWait wait, String pattern, String keys) {
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pattern)));
        login.clear();
        login.sendKeys(keys);
    }

}
