package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Validating_isEnabled_59 extends TestBase{
    @Test
    public void isEnabled(){

        //SU ANKI SITEDE BU CALISMIYOR AMA MANTIK GUZEL, IF VE ASSERTION KULLANIMI OZELLIKLE

        driver.get("https://www.makemytrip.com/");

        // System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))

        {

            System.out.println("its enabled");

            Assert.assertTrue(true);

        }

        else

        {

            Assert.assertTrue(false);

        }
    }

}
