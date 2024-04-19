package listenerstestng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomerListener.class)

public class TC01 {
    @Test(groups = {"sanity"})
    public void test1(){
        System.out.println("doing sanity test");
        Assert.assertTrue(true);
    }
    @Test(groups = {"sanity"})
    public void test2(){
        System.out.println("doing sanity test case2");
        Assert.assertTrue(true);
    }
}
