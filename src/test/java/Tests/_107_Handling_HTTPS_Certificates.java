package Tests;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class _107_Handling_HTTPS_Certificates extends TestBase {
    @Test
    public void testName() {

        //it is a confusing topic, see the related class video
        DesiredCapabilities chrome = DesiredCapabilities.chrome();
        chrome.acceptInsecureCerts();
//        chrome.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(chrome);
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://cacert.org/");
    }
}
