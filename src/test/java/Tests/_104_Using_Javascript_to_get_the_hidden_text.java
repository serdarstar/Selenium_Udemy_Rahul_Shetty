package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class _104_Using_Javascript_to_get_the_hidden_text extends TestBase {

    /*
    1.Enter BENG
    2. Verify if Airport option is displayed in the suggestive box
     */

    @Test
    public void testName() throws InterruptedException {
        driver.get("https://ksrtc.in/oprs-web/guest/home.do#");
        //When send MUM, MUMBAI is shown in the box as a hidden text, the code below does not capture it
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
        System.out.println("text = " + driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());

        //to get the hidden text, we have to use Javascript Executor
        //using polymorphism downcasting to define new driver
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        //to get any data from javascript, first, create a string for query, add semicolon at the end and write return in the beginning
        String script = "return document.getElementById(\"fromPlaceName\").value;";

        //excute the query and save it as a string by casting
        String text = (String) javascriptExecutor.executeScript(script);

        //now you can get the text
        System.out.println("text = " + text);

        while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
            //After this point, while loop will start to do arrow down. But, if it will need sometime to text to appear, then put some sleep
            Thread.sleep(1000);
            text = (String) javascriptExecutor.executeScript(script);
        }
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER);

//        if text is not found, then while loop will execute indefinitely. To finish it, use the code below
//
//        int count=0;
//        while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRP")) {
//            count++;
//            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
//            //After this point, while loop will start to do arrow down. But, if it will need sometime to text to appear, then put some sleep
//            Thread.sleep(1000);
//            text = (String) javascriptExecutor.executeScript(script);
//            if (count>10){
//                break;
//            }
//
//        }
//        if (count>10){
//            System.out.println("Text not found");
//        } else System.out.println("element found");

    }
}
