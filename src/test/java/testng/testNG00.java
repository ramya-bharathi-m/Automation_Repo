package testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class testNG00 {
    //Try to create put request
    //before test
    //I need ....
    //token, header, body

    RequestSpecification r;
    ValidatableResponse v;
    String token;
    Integer bookingId;

    public String createToken(){
        System.out.println(" ~~~ !! CREATING TOKEN !! ~~~");
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);


        Response response =  r.post();
        v = response.then();
        v.statusCode(200);

        //REST ASSURED -- Matchers (Hamcrest) only 1 to 2 % companies use
        v.body("token", Matchers.notNullValue());

        //Test NG assertions
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
        System.out.println("token is" +" "+ token);

        //AssertJ Assertions
        assertThat(token).isNotNull().isNotBlank().isNotEmpty();
        System.out.println("token value " + " " + token);
        return token;
    }
    @BeforeTest
    public void createBookingIdNonBDDPost(){
        System.out.println(" ~~~ !! CREATING BOOKING ID !! ~~~");
        token = createToken();
        String payload = "{\n" +
                "    \"firstname\" : \"Ramya\",\n" +
                "    \"lastname\" : \"Bharathi\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload);

        Response response = r.post();

        v = response.then().log().all();
        v.statusCode(200);
        bookingId = response.then().log().all().extract().path("bookingid");

        String responseString = response.asString();

        System.out.println("Booking id is " + " "+ bookingId);
    }
    @Test
    public void putNonBDDRequest(){
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

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId).log().all();
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload);

        Response response = r.put();

        v = response.then().log().all();
        v.statusCode(200);
        v.body("firstname",Matchers.equalTo("Kruthic"));



    }
}
