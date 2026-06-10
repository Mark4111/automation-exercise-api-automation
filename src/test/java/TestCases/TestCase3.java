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

@Feature("Brands API")
public class TestCase3 extends BaseTest{

    @Story("Get All Brands List")
    @Description("Verify that the brands list endpoint returns status code 200 and a non-empty brands list")
    @Test
    public void TC3_GetAllBrandsList(){
        Response response = given()
                .when().get(ConfigReader.getProperty("brandsList"));
        // Print Response
        response.then().log().all();
        //HTTP Status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,200);
        // Brands list is not empty
        Assert.assertFalse(response.jsonPath().getList("brands").isEmpty());
    }
}
