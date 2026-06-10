package TestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import utilis.AssertionsHelper;
import utilis.ConfigReader;
import utilis.TestDataHolder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
@Feature("Account API")
public class TestCase12 extends BaseTest{
    @Story("Delete Account")
    @Description("Verify that user account can be deleted successfully using valid credentials")
    @Test
    public void TC12_DeleteUserAccount()
    {
        Response response = given()
                .formParam("email", TestDataHolder.createdEmail)
                .formParam("password", TestDataHolder.createdUser.getPassword())
                .when()
                .delete(ConfigReader.getProperty("deleteAccount"));
        //print response
        response.then().log().all();
        //status code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,200);
        //response msg
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "accountDeletedMessage");
        Assert.assertTrue(response.jsonPath().getString("message").contains(expectedMessage));
    }
}
