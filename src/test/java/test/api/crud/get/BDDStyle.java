package test.api.crud.get;


import io.restassured.RestAssured;

    public class BDDStyle {
        public static void main(String[] args) {


            //DOING A CASE FOR GET METHOD
            //https://api.zippopotam.us/IN/602024 USING THIS URL
            //API TO GET INFO ABOUT ANY AREA POSTCODE CAN CHECK FOR ANY COUNTRY

            // rest assured is like builder pattern method / method chaining in java
            // we call method with dot operator continuously without calling seperately
            //It follows the same design pattern

            /******VERY SIMPLE GET METHOD AUTOMATION*****/
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us").basePath("/IN/602024")

                    .when().log().all()
                    .get()

                    .then().log().all()
                    .statusCode(200);
        }


}
