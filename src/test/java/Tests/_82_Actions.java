package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class _82_Actions extends TestBase{
    @Test
    public void Actions() {
        driver.get("https://www.amazon.co.uk/");
        WebElement search= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'.co.uk')]"))).contextClick().
          sendKeys(Keys.ARROW_DOWN).pause(2000).sendKeys(Keys.ARROW_DOWN).pause(2000).click().build().perform();



    }
}
