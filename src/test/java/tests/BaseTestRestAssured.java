package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import utils.ResourcesUtils;

public class BaseTestRestAssured {

    @BeforeMethod
    public static void setUp() throws Exception {
        RestAssured.baseURI = ResourcesUtils.getResources("configs","baseUriForApi");
    }
}
