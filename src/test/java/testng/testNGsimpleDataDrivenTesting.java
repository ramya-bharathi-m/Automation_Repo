package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNGsimpleDataDrivenTesting {

    //THIS IS HARCODED DATAAAAA
    @DataProvider
    public Object[][] getData(){
        return new Object[][]  {
                new Object[]{"admin","password"},
                new Object[]{"admin","pwd1"},
                new Object[]{"admin","pwd1"},
                new Object[]{"admin","pwd1"},
                new Object[]{"admin","pwd1"},
                new Object[]{"admin","pwd1"},
                new Object[]{"admin","pwd1"},
                new Object[]{"admin","pw23"}
        };
    }
    @Test(dataProvider = "getData")
    public void loginTest(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
}
