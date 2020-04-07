package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class _85_Window_Handles extends TestBase{

    @Test
    public void testName() {
        driver.get("http://the-internet.herokuapp.com/windows");
        WebElement window= driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        window.click();
        System.out.println(driver.getTitle());
        Set<String> ids=driver.getWindowHandles();
        Iterator<String> it=ids.iterator();
        String parentWindowHandle=it.next();
        String childWindowHandle=it.next();
        driver.switchTo().window(childWindowHandle);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentWindowHandle);
        System.out.println(driver.getTitle());


    }

}

