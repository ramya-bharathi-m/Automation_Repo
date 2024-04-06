package test.api.crud.patch;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPatch {

    Response response;
    ValidatableResponse validatableResponse;
    String token = "55f974cef0e4ac1";


    @Test
    public void NonBDDPatch(){
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/1");
        r.contentType("application/json");
        r.cookie("token",token);
        r.body(payload).log().all();

        response = r.when().patch();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));
    }
}
