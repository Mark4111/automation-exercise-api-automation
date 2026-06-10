package TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import utilis.AssertionsHelper;
import utilis.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("Login API")
public class TestCase9 extends BaseTest{
    @Story("Invalid HTTP Method - Delete Login")
    @Description("Verify that sending DELETE request to login endpoint returns 405 method not allowed")
    @Test
    public void TC9_DeleteToVerifyLogin(){
        Response response = given()
                .when().delete(ConfigReader.getProperty("verifyLogin"));
        //print response
        response.then().log().all();
        //status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,405);
        //response Msg
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "methodNotSupportedMessage");
        Assert.assertTrue(response.jsonPath().getString("message").contains(expectedMessage));
    }
}
