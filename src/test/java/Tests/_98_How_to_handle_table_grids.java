package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _98_How_to_handle_table_grids extends TestBase{
    @Test
    public void testName() {
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/26574/pak-vs-ban-2nd-t20i-bangladesh-tour-of-pakistan-2020");
        WebElement table=driver.findElement(By.xpath("//div[@id='innings_1']/div[1]"));
        System.out.println(table.findElements(By.xpath("//div[@id='innings_1']/div[1]/div/div[2]")).size());
        List<WebElement> tableList= driver.findElements(By.xpath("//div[@id='innings_1']/div[1]/div/div[3]"));

        List<String> tableListString=new ArrayList<>();
        for (int i = 1; i < tableList.size()-2; i++) {
            System.out.println(tableList.get(i).getText());
            tableListString.add(tableList.get(i).getText());
        }
        System.out.println(driver.findElement(By.xpath("(//div[contains(text(),'Extras')])[1]/following-sibling::div[1]")).getText());
        tableListString.add(driver.findElement(By.xpath("(//div[contains(text(),'Extras')])[1]/following-sibling::div[1]")).getText());

        List<Integer> tableListInteger=new ArrayList<>();
        int sum=0;
        for (int i = 0; i < tableListString.size(); i++) {
            tableListInteger.add(Integer.parseInt(tableListString.get(i)));
            sum=sum+tableListInteger.get(i);

        }
        System.out.println("sum = " + sum);
        int total=Integer.parseInt(driver.findElement(By.xpath("(//div[contains(text(),'Total')])[1]/following-sibling::div[1]")).getText());
        Assert.assertEquals(sum,total);


    }
}
