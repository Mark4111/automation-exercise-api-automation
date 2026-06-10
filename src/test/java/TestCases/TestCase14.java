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
public class TestCase14 extends BaseTest{
    @Story("Get User Details")
    @Description("Verify that user details can be retrieved successfully using valid email")
    @Test
    public void TC14(){
        Response response = given()
                .param("email", TestDataHolder.createdEmail)
                .when().get(ConfigReader.getProperty("getUserDetail"));
        //print Response
        response.then().log().all();
        //Status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,200);
        //response MSG
        Assert.assertEquals(response.jsonPath().getString("user.email"),TestDataHolder.createdEmail);
    }
}
