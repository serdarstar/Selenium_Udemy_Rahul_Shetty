package Tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _145_Parametirising{
    @Parameters("URL")
    @Test
    public void testName(@Optional String url) {
        System.out.println(url);
    }
}
