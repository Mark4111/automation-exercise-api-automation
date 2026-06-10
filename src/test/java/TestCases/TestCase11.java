package TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pojo.RegisterUserPojo;
import utilis.AssertionsHelper;
import utilis.ConfigReader;
import utilis.TestDataHolder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
@Feature("Account API")
public class TestCase11 extends BaseTest{
    @Story("Create Account")
    @Description("Verify that user account can be created successfully using valid data")
    @Test
    public void TC11_PostToCreate_RegisterUserAccount()
    {
        RegisterUserPojo newUser = Utils.JsonHelper
                .readJsonAsObject("src/main/resources/TestData/RegisterUser.json", RegisterUserPojo.class);

        String EmailUnique = "mark" + System.currentTimeMillis() + "@gmail.com";

        TestDataHolder.createdEmail = EmailUnique; // to save email for next api
        newUser.setEmail(EmailUnique);

        TestDataHolder.createdUser = newUser;

        Map<String, Object> userData = Utils.JsonHelper.convertObjectToMap(newUser);

        Response response = given()
                .formParams(userData)
                .when().post(ConfigReader.getProperty("createAccount"));
        //print response
        response.then().log().all();
        //status code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,201);
        //response msg
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "userCreatedMessage");
        Assert.assertTrue(response.jsonPath().getString("message").contains(expectedMessage));
    }
}
