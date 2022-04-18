package tests;

import utils.ResourcesUtils;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTests {

    @Test
    public void RestAssuredFirstTest() throws Exception {

        RestAssured.baseURI= ResourcesUtils.getResources("configs","baseUri");
         Response response =given().
                when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}
