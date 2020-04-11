package Tests2;

import Tests.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;

public class Dropdown_48 extends TestBase {
    @Test (groups = {"smoke"})

    public void dropdown() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_originStation1']")));
        System.out.println("select.getOptions().size() = " + select.getOptions().size());
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getAttribute("text"));
        }
        WebElement adult = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
        System.out.println("adult.getText() = " + adult.getText());
        adult.click();

        Select select1 = new Select(driver.findElement(By.xpath("//select[@name='ctl00$mainContent$ddl_Adult']")));
        List<WebElement> adultNumber = select1.getOptions();
        adultNumber.get(3).click();
        System.out.println("adult.getText() = " + adult.getText());
    }


//    if we know there is a bug in the case and we want to skip, we use enabled=false helper attribute
    @Test(enabled = false)
    public void dropdown_dynamic() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        driver.findElement(By.xpath("//input[@name='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("(//a[@value='IXB'])[2]")).click();

//        burda calismadi ama index kullanmadan ikinciyi bulmanin yolu
//        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).click();
    }

//    dependsOnMethods koyarak, bu test ancak depend oldugu testler calistiktan sonra calissin diyebiliriz
    @Test(dependsOnMethods ={"dropdown","AutoSuggestive_Getting_text"})
    public void dropdown_Auto_Suggestive() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        WebElement placeHolder = driver.findElement(By.xpath("//input[@placeholder='From']"));
        placeHolder.click();
        placeHolder.sendKeys("MUM");
        placeHolder.sendKeys(Keys.ARROW_DOWN);
        placeHolder.sendKeys(Keys.ENTER);

        WebElement toCity = driver.findElement(By.xpath("//span[contains(text(),'To')]"));
        WebElement placeHolderTo = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toCity.click();
        placeHolderTo.click();
        placeHolderTo.sendKeys("DEL");

        for (int i = 0; i < 3; i++) {
            placeHolderTo.sendKeys(Keys.ARROW_DOWN);
        }
        placeHolderTo.sendKeys(Keys.ENTER);


    }

    @Test(timeOut = 4000)//timeout belirlyerek bu sureden once fail olma diyebiliriz
    public void AutoSuggestive_Getting_text() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        WebElement placeHolder = driver.findElement(By.xpath("//input[@placeholder='From']"));
        placeHolder.click();
        placeHolder.sendKeys("MUM");
        for (int i = 0; i < 4; i++) {
            placeHolder.sendKeys(Keys.ARROW_DOWN);
            System.out.println("placeHolder.getAttribute(\"value\") = " + placeHolder.getAttribute("value"));
        }

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
