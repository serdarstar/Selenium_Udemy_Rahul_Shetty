package Project_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Annotations {
    public WebDriver driver;
    Properties properties = new Properties();

    @BeforeSuite
    public void Login() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Selenium_Udemy\\src\\test\\java\\Project_2\\project2.properties");
        properties.load(fileInputStream);
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

        if (properties.getProperty("browser").contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(properties.getProperty("browser").contains("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }


    }
}
