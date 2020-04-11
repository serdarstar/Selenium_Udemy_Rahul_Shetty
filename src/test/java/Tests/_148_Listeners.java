package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class _148_Listeners implements ITestListener {

    //Here we can define what will TestNG do in the following scenarios


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotAs,new File("C:\\Users\\User\\IdeaProjects\\Selenium_Udemy\\src\\test\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Failure happened ");
        System.out.println("result.getName() = " + result.getName());
        System.out.println("result.getTestName() = " + result.getTestName());
        System.out.println("result.getInstanceName() = " + result.getInstanceName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
