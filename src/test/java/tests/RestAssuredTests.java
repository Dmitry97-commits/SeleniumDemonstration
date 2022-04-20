package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import models.DataModel;
import models.UsersModel;
import org.testng.asserts.SoftAssert;
import utils.ResourcesUtils;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import static io.restassured.RestAssured.given;

public class RestAssuredTests extends BaseTestRestAssured{

    Faker faker = new Faker();

    @Test(description = "Get all posts")
    public void RestAssuredFirstTest() throws Exception {

         Response response =given().
                when()
                .get(ResourcesUtils.getResources("configs","pathToFirstTest"))
                .then()
                .statusCode(200)
                .extract()
                .response();

         System.out.println(response.body().print());
    }

    @Test(description = "Make post request")
    public void RestAssuredSecondTest() throws Exception {

        DataModel user = new DataModel();
        user.setUserId(faker.idNumber().hashCode());
        user.setId(faker.idNumber().hashCode());
        user.setTitle(faker.name().name());
        user.setBody(faker.random().hex());

        Response response =given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(ResourcesUtils.getResources("configs","pathToSecondTest"))
                .then()
                .statusCode(201)
                .extract()
                .response();

        System.out.println(response.body().print());
    }

    @Test(description = "Compare json document with object from response")
    public void ThirdRestAssuredTest() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        UsersModel userFromJson = mapper.readValue(new File(ResourcesUtils.getResources("configs","pathToJson")), UsersModel.class);

        Response response =given().
                when()
                .get(ResourcesUtils.getResources("configs","pathToThirdTest"))
                .then()
                .statusCode(200)
                .extract()
                .response();

        UsersModel userFromResponse = mapper.readValue(response.body().print(), UsersModel.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(userFromResponse.id, userFromJson.id);
        softAssert.assertEquals(userFromResponse.name, userFromJson.name);
        softAssert.assertEquals(userFromResponse.username, userFromJson.username);
        softAssert.assertEquals(userFromResponse.email, userFromJson.email);
        softAssert.assertEquals(userFromResponse.address.city, userFromJson.address.city);
        softAssert.assertEquals(userFromResponse.address.street, userFromJson.address.street);
        softAssert.assertEquals(userFromResponse.address.suite, userFromJson.address.suite);
        softAssert.assertEquals(userFromResponse.address.zipcode, userFromJson.address.zipcode);
        softAssert.assertEquals(userFromResponse.address.geo.lat, userFromJson.address.geo.lat);
        softAssert.assertEquals(userFromResponse.address.geo.lng, userFromJson.address.geo.lng);
        softAssert.assertEquals(userFromResponse.phone, userFromJson.phone);
        softAssert.assertEquals(userFromResponse.website, userFromJson.website);
        softAssert.assertEquals(userFromResponse.company.catchPhrase, userFromJson.company.catchPhrase);
        softAssert.assertEquals(userFromResponse.company.bs, userFromJson.company.bs);
        softAssert.assertEquals(userFromResponse.company.name, userFromJson.company.name);

        softAssert.assertAll("Information doesn't match");

    }

}
