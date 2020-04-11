package Project_2;

import org.testng.annotations.Test;

//Farkli bir sekilde Annatations class icinde configuration reader olusturup extends ile calistirmak
public class _152_Global_Parameter_Configuration_Reader extends Annotations{
    @Test
    public void testName() {
        System.out.println("a");
        driver.get(properties.getProperty("url"));
    }
}
