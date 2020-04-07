package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class _94_Handling_calendar_UI_in_Travel_websites extends TestBase {

    @Test
    public void start() {
        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.xpath("//input[@id='travel_date']")).click();
//        driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]"));

        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("December")){
            driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")).click();
        }

        List<WebElement> days=driver.findElements(By.cssSelector(".day"));
        System.out.println("days.size() = " + days.size());
        for (int i = 0; i < days.size(); i++) {
             String dayText=days.get(i).getText();
            System.out.println(dayText);
             if(dayText.equals(day())){
                 days.get(i).click();
                 break;
             }
        }
    }

    public String day(){
        String day="24";
        return day;
    }

}
