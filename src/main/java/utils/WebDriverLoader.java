package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverLoader {


    public static WebDriver setDriver(){
        System.setProperty("webdriver.gecko.driver", getPath());

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);
        //= new HtmlUnitDriver();
        //driver.setJavascriptEnabled(true);
        return new FirefoxDriver(options);
    }

    private static String  getPath() {
        Properties property = new Properties();
        String path = null;

        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")){
            property.load(fis);
            path = property.getProperty("path");
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return  path;
    }

    public static WebDriverWait setWait(WebDriver driver, int timeOutSeconds) {
        return new WebDriverWait(driver, timeOutSeconds);
    }

    public static void loadPage(WebDriver driver, String pageName){
        driver.get(pageName);
    }
}
