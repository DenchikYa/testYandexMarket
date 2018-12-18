package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {
    String filePath = "~/Projects/TestSSU/screenshots";

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error " + result.getName() + " test has failed *****");
        String methodName = result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
        takeScreenShot(methodName, driver);
    }

    public void takeScreenShot(String methodName, WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in destination directory with name "screenshot.png"
            FileHandler.copy(scrFile, new File(filePath + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

