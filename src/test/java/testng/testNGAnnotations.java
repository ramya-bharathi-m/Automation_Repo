package testng;

import org.testng.annotations.*;

public class testNGAnnotations {
    @BeforeSuite
    void demo(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    void demo2(){
        System.out.println("After Suite");
    }
    @BeforeTest
    void demo3(){
        System.out.println("Before Test");
    }
    @AfterTest
    void demo4(){
        System.out.println("After Test");
    }
    @BeforeClass
    void demo5(){
        System.out.println("Before Class");
    }
    @AfterClass
    void demo6(){
        System.out.println("After Class");
    }
    @BeforeMethod
    //basically used to read some kind of files
    //like json, database, csv files or excel before testing
    void demo7(){
        System.out.println("Before Method");
    }
    @AfterMethod
    //same as before method
    // to read files after test is run
    void demo8(){
        System.out.println("After Method");
    }
    @Test
    void demo1(){
        System.out.println("Test");
    }


}
