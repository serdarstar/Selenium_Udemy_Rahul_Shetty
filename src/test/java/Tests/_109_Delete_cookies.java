package Tests;

import org.testng.annotations.Test;

public class _109_Delete_cookies extends TestBase {
    @Test
    public void testName() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com/");
        //if you are on a bank website and need to secure log out, you need to delete session cookie
        driver.manage().deleteCookieNamed("give the name of the cookie for the company or website");

    }
}
