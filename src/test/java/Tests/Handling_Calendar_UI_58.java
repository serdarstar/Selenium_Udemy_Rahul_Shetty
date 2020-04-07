package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Handling_Calendar_UI_58 extends TestBase {
    @Test
    public void calendar(){
        driver.get("https://www.makemytrip.com/");
        WebElement calendar=driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]"));
        calendar.click();

    }
}
