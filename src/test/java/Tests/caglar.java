package Tests;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class caglar extends TestBase {
    @Test
    public void testName() throws InterruptedException {
        driver.get("https://auth.packlink.com/es-ES/pro/login?platform=PRO&platform_country=ES");
        driver.findElement(By.name("email")).sendKeys("qacandidatecaglar@packlink.es");
        driver.findElement(By.name("password")).sendKeys("1Q2w3e4r5t6y");
        driver.findElement(By.xpath("//button[@class='btn--primary btn']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='eb-add-shipment__btn']")).click();
//        driver.findElement(By.xpath("//fieldset[1]//div[1]//country-postal-code-selector[1]//packlink-selector[2]//div[1]//label[1]")).click();
//        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("ma");
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector(".eb-selector__user-input.js-selector-input.ng-pristine.ng-valid.ng-empty.ng-touched")).sendKeys("ma");
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//fieldset[1]//div[1]//country-postal-code-selector[1]//packlink-selector[2]//div[1]//label[1]/preceding-sibling::input")).sendKeys("ma");




    }
}
