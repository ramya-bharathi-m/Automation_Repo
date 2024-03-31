package test.api.crud.get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetNonBDDTestNG {
    @Test
    public void getBookingPositive(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2795");
        r.when().get();
        r.then().log().all().statusCode(200);
    }
    @Test
    public void getBookingNegative1(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-10");
        r.when().log().all().get();
        r.then().log().all().statusCode(404);
    }
    @Test
    public void getBookingNegative2(){
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/xxx");
        r.when().log().all().get();
        r.then().log().all().statusCode(404);
    }
}
