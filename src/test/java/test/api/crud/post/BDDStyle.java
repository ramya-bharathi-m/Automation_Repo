package test.api.crud.post;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BDDStyle {
    @Test
    public void createTokenBDDPostPositive(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        //payloads can be hashmap, string, class
        //classes are used 60 to 70%

        RestAssured.given()
        .baseUri("https://restful-booker.herokuapp.com")
        .basePath("/auth").contentType("application/json")
        .body(payload)
        .when().log().all().post()
        .then().log().all().statusCode(200);
    }
}
