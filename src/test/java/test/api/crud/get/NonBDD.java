package test.api.crud.get;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDD {
    public static void main(String[] args) {

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com").basePath("/booking/2795").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }
}
