package test.api.crud.put;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

public class NonBDDPut {

    Response response;
    ValidatableResponse validatableResponse;
    String token = "55f974cef0e4ac1";
    @Test
    public void nonBDDPutRequest(){
        //url
        //id - 2945
        //auth token - 55f974cef0e4ac1
        //header - json
        //payload

        String payload = " {\n" +
                "    \"firstname\" : \"Kruthic\",\n" +
                "    \"lastname\" : \"Vignesh\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/3581");
        r.cookie("token",token);
        r.contentType("application/json");
        r.body(payload);

        response = r.when().log().all().put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Kruthic"));
        //r.then().statusCode(200);

    }
}
