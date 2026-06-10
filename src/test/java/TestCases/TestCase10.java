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
public class TestCase10 extends BaseTest{
    @Story("Invalid Login - Wrong Credentials")
    @Description("Verify that login API returns error when email and password are invalid")
    @Test
    public void TC10_PostToVerifyLoginWithInvalidDetails(){
        Response response = given()
                .param("email",INVALID_EMAIL)
                .param("password",INVALID_PASSWORD)
                .when().post(ConfigReader.getProperty("verifyLogin"));
        //print response
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,404);
        //response msg
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "userNotFoundMessage");
        Assert.assertTrue(response.jsonPath().getString("message").contains(expectedMessage));
    }
}
