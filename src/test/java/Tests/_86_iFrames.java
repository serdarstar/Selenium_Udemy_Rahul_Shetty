package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _86_iFrames extends TestBase {
    @Test
    public void testName() {

        driver.get("https://jqueryui.com/draggable/");
        System.out.println("driver.findElements(By.tagName(\"iframe\")).size() = " + driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
//        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        WebElement dragabble=driver.findElement(By.xpath("//div[@id='draggable']"));
        System.out.println(dragabble.getText());
        actions.moveToElement(dragabble).dragAndDropBy(dragabble,120, 115).build().perform();
//        ana sayfaya donmek, frame den cikmak icin
        driver.switchTo().defaultContent();

    }
}
