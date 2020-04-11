package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class _110_How_to_take_screenshot extends TestBase {
    @Test
    public void testName() throws IOException {
        driver.get("https://www.google.com/");
//        TakesScreenshot driver = (TakesScreenshot) TestBase.driver;

        File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs,new File("C:\\Users\\User\\IdeaProjects\\Selenium_Udemy\\src\\test\\screenshot.png"));

    }
}
