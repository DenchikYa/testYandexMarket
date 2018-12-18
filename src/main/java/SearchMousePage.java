import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchMousePage {

    public static List<String> getMousesForPage(WebDriverWait wait){
        List<String> retVal = new ArrayList<>();

        List<WebElement> mouses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("n-snippet-list")))
                .findElements(By.xpath("//div[@class = 'price']"));

        for (WebElement e : mouses) {
            retVal.add(e.getText().replaceAll("\u20BD", "").replaceAll(" ", ""));
        }

        return  retVal;
    }

}
