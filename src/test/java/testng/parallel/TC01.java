package parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01 {
    @BeforeMethod
    public void beforeMe(){
        long id = Thread.currentThread().threadId();
        System.out.println("before method"+" "+id);
    }
    @AfterMethod
    public void afterMe(){
        long id = Thread.currentThread().threadId();
        System.out.println("after method"+" "+id + getClass().getSimpleName());
    }
    @Test
    public void test1(){
        long id = Thread.currentThread().threadId();
        System.out.println("testcase 1"+" "+id);
    }
    @Test
    public void test2(){
        long id = Thread.currentThread().threadId();
        System.out.println("testcase 2"+" "+id);
    }
    @Test
    public void test3(){
        long id = Thread.currentThread().threadId();
        System.out.println("testcase 3"+" "+id);
    }
}
