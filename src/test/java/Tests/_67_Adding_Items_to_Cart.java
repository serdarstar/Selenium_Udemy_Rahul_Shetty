package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class _67_Adding_Items_to_Cart extends TestBase {

    @Test
    public void addingCart() throws InterruptedException {

        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
//        driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(1).click();
//        System.out.println(driver.findElements(By.xpath("//button[text()='ADD TO CART']")).toString());

        String[] products = {"Cucumber", "Brocoli"};

        List<WebElement> name = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < name.size(); i++) {
            if (name.get(i).getText().contains("Cucumber")) {
                for (int j = 0; j < 5; j++) {
                    driver.findElements(By.cssSelector(".increment")).get(i).click();
                }
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
            }
        }
    }



    @Test
    public void add_as_array() throws InterruptedException {
        driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
        String[] itemsNeeded = {"Cucumber", "Brocolli"};

        //to make this test clean, we created a method below (see lesson 74)
        addItems(driver,itemsNeeded);
        WebElement cart=driver.findElement(By.cssSelector("img[alt='Cart']"));
        cart.click();
        WebElement checkout=driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
        checkout.click();
        WebElement promoCode=driver.findElement(By.cssSelector(".promoCode"));
        WebElement promoBtn=driver.findElement(By.cssSelector(".promoBtn"));

        promoCode.sendKeys("rahulshettyacademy");
        promoBtn.click();
        WebElement promoInfo=driver.findElement(By.cssSelector(".promoInfo"));
        wait.until(ExpectedConditions.visibilityOf(promoInfo));
        Assert.assertEquals(promoInfo.getText(),"Code applied ..!");
        WebElement placeOrder=driver.findElement(By.xpath("//button[contains(text(),'Place')]"));
        placeOrder.click();

    }


    public void addItems(WebDriver driver, String[] itemsNeeded){
        //convert Array to ArrayList, to be able to make comparison based on index, convert to ArrayList, but ArrayList consumes more memory
        List itemsNeededList= Arrays.asList(itemsNeeded);
        List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < product.size(); i++) {
            String name=product.get(i).getText();
            //to get rid of -1 kg at the end of the text, use substring
            name=name.substring(0,name.length()-7);
            System.out.println("name = " + name);
//            System.out.println("name = " + name);
            int count=0;
            if (itemsNeededList.contains(name)){
                count++;
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                if(count==itemsNeededList.size()){
                    break;
                }
            }

        }

    }

}
