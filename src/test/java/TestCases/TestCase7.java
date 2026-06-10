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
public class TestCase7 extends BaseTest{
    @Story("Valid Login")
    @Description("Verify that user can login successfully using valid email and password")
    @Test
    public void TC07_PostToVerifyLoginWithValidDetails(){

        Response response = given()
                .param("email",Email)
                .param("password",Password)
                .when().post(ConfigReader.getProperty("verifyLogin"));
        //print response
        response.then().log().all();
        //Status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,200);
        //response msg
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "userExistsMessage");

        Assert.assertTrue(response.jsonPath().getString("message").contains(expectedMessage));
    }
}
