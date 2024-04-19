package testng;

import org.testng.annotations.Test;

public class testNGgroups {
    @Test(groups = {"sanity","positive"})
    public void sanity(){
        System.out.println("sanity");
    }
    @Test(groups = {"regression","sanity","negative"})
    public void regression(){
        System.out.println("regression");
    }
    @Test(groups = {"smoke","sanity","postive"})
    public void smoke(){
        System.out.println("smoke");
    }
}
