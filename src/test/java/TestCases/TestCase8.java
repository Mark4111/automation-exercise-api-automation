package TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import utilis.AssertionsHelper;
import utilis.ConfigReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
@Feature("Login API")
public class TestCase8 extends BaseTest {
    @Story("Invalid Login - Missing Email")
    @Description("Verify that login API returns error when email parameter is missing")
    @Test
    public void TC08_PostToVerifyLoginWithoutEmailParameter() {
        Response response = given()
                .param("password",Password)
                .when().post(ConfigReader.getProperty("verifyLogin"));
        //print response
        response.then().log().all();
        //Status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,400);
        //Response MSG
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "missingLoginDataMessage");
        Assert.assertTrue(response.jsonPath().getString("message")
                .contains(expectedMessage));
    }
}
