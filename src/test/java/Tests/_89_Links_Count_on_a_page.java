package Tests;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class _89_Links_Count_on_a_page extends TestBase {
    @Test
    public void testName() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //sadec footer section daki linkleri almak icin yeni bir driver olusturarak sub-driver yapilir
        WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        WebElement latestNewsDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']//td[2]"));
        System.out.println(latestNewsDriver.findElements(By.tagName("a")).size());

//        daha da daraltmak icin
        List links = Arrays.asList(latestNewsDriver.findElements(By.tagName("a")));
        List<WebElement> elementList = latestNewsDriver.findElements(By.tagName("a"));

        for (int i = 0; i < elementList.size(); i++) {
            String a = elementList.get(i).getText();
            System.out.println(a);
        }
        elementList.get(1).click();

//        ilk blok linkleri almak icin
        WebElement discountLinks = driver.findElement(By.xpath("//td[1]//ul"));
        System.out.println("discountLinks.findElements(By.tagName(\"a\")).size() = " + discountLinks.findElements(By.tagName("a")).size());

        //buradaki butun linklerin calisip calismadigini kontrol icin

        for (int i = 0; i < discountLinks.findElements(By.tagName("a")).size(); i++) {

            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            discountLinks.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }

//      butun linkler yeni tabda acilmis durumda, hepsinin window handle larini alip itarator a tanitiyoruz

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();

//        itarator loop un bir ozelligi olarak it.hasNext, yani yeni bir handle oldugu muddetce while loop it.next ile bir sonrakine gecip title i yazdiracak
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        }

    }
}
