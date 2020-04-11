package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _146_DataProvider {
    @Test(dataProvider = "getData")
    public void testName(String username, String password) {
        System.out.println(username+" "+ password);
    }

    @DataProvider
    public Object[][] getData(){
        Object [][] data=new Object[3][2];
        data[0][0]="username1";
        data[0][1]="password1";
        data[1][0]="username2";
        data[1][1]="password2";
        data[2][0]="username3";
        data[2][1]="password3";
        return data;
    }

}
