package TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import utilis.AssertionsHelper;
import utilis.ConfigReader;
import io.restassured.response.Response;
import pojo.RegisterUserPojo;
import utilis.TestDataHolder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
@Feature("Account API")
public class TestCase13 extends BaseTest{
    @Story("Update Account")
    @Description("Verify that user account can be updated successfully with valid data")
    @Test
    public void TC13_UpdateUserAccount(){
        RegisterUserPojo updateUser = TestDataHolder.createdUser;
        updateUser.setName("MarkUpdated");
        updateUser.setCity("Nasr City");

        Map<String, Object> userData = Utils.JsonHelper.convertObjectToMap(updateUser);

        Response response = given()
                .formParams(userData)
                .when().put(ConfigReader.getProperty("updateAccount"));
        //print response
        response.then().log().all();
        //status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,200);
        //response MSG
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "userUpdatedMessage");
        Assert.assertTrue(response.jsonPath().getString("message").contains(expectedMessage));
    }
}
