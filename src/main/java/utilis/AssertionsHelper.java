package utilis;

import io.restassured.response.Response;
import org.testng.Assert;


public class AssertionsHelper {
    public static void assertStatusCode (Response response, int expectedStatusCode) {
        //status Code
        Assert.assertEquals(response.getStatusCode(),expectedStatusCode);
    }
    public static void assertResponseCode (Response response, int expectedResponseCode) {
        //response code
        Assert.assertEquals(response.jsonPath().getInt("responseCode"),expectedResponseCode);
    }
}
