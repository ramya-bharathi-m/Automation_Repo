package testng;

import org.testng.annotations.Test;

public class testNGdependsOnMethod {

    //NORMAL WAY OF DEPENDS UPON
//    @Test
//    public void serverStartedOK(){
//        System.out.println("I will run first");
//    }
//    @Test(dependsOnMethods = "serverStartedOK")
//    public void method(){
//        System.out.println("dependent method");
//    }

    //USING DEPENDENCY WITH GROUPS
    //IF REMOVED PRIORITY IT WILL RUN IN DIFFERENT ORDER
    @Test(groups = {"init"},priority = 1)
    public void serverStartedOK(){
        System.out.println("I will run first");
    }
    @Test(groups = {"init"},priority = 2)
    public void initEnv(){
        System.out.println("env method");
    }
    @Test(dependsOnGroups = {"init.*"})
    public void method(){
        System.out.println("I am dependent");
    }


}