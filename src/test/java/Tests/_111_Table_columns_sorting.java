package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class _111_Table_columns_sorting extends TestBase {
    @Test
    public void verify_ascending() {
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");
       WebElement sortButton=driver.findElement(By.cssSelector("tr th:nth-child(2)"));
//      to sort as descending
        sortButton.click();
//        to sort as ascending
        sortButton.click();

        List<WebElement> vegies=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        List<String> vegiesList= new ArrayList<>();

        for (int i = 0; i < vegies.size(); i++) {
             vegiesList.add(vegies.get(i).getText());
        }
        System.out.println("vegiesList.toString() = " + vegiesList.toString());
//        Collections.sort(vegiesList);
        List<String> vegiesListSorted=new ArrayList<>(vegiesList);
        System.out.println("vegiesListSorted.toString() = " + vegiesListSorted.toString());
        Collections.sort(vegiesListSorted);
        System.out.println("vegiesListSorted.toString() = " + vegiesListSorted.toString());

        Assert.assertEquals(vegiesList,vegiesListSorted);


    }

    @Test
    public void verify_descending() {

//        This code is almost the same with the above, just compares if descending

        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement sortButton=driver.findElement(By.cssSelector("tr th:nth-child(2)"));
//      to sort as descending
        sortButton.click();

        List<WebElement> vegies=driver.findElements(By.xpath("//tbody/tr/td[2]"));
        List<String> vegiesList= new ArrayList<>();

        for (int i = 0; i < vegies.size(); i++) {
            vegiesList.add(vegies.get(i).getText());
        }
        System.out.println("vegiesList.toString() = " + vegiesList.toString());

        List<String> vegiesListSorted=new ArrayList<>(vegiesList);


        System.out.println("vegiesListSorted.toString() = " + vegiesListSorted.toString());

        Collections.sort(vegiesListSorted);
        Collections.reverse(vegiesListSorted);
        System.out.println("vegiesListSorted.toString() = " + vegiesListSorted.toString());

        Assert.assertEquals(vegiesList,vegiesListSorted);





    }
}
