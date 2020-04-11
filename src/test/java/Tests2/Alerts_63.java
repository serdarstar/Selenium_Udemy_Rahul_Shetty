package Tests2;

import Tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Alerts_63 extends TestBase{
    @Test(groups = { "smoke" })
    public void alerts(){

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("star");

        driver.findElement(By.cssSelector("[id='alertbtn']")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();


    }

    //Below are to check annotations

    @BeforeMethod
    public void beforemethod(){
        System.out.println("I run before each and every test in the class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I run before every test in XML file, don't confuse with @BeforeMethod");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I run firstly and once before every tests in a class");
    }

    @BeforeSuite
    public void BeforeSuit(){
        System.out.println("I run before all tests, classes and packages");
    }
}
