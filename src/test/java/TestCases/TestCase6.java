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
@Feature("Products API")
public class TestCase6 extends BaseTest{
    @Story("Search Product - Negative Case")
    @Description("Verify that search product API returns error when search_product parameter is missing")
    @Test
    public void TC06_PostToSearchProductWithoutSearch_productParameter(){
        Response response = given()
                .when().post(ConfigReader.getProperty("searchProduct"));
        //print response
        response.then().log().all();
        //Status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,400);
        //Response MSG
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "missingSearchProductMessage");
        Assert.assertTrue(response.jsonPath().getString("message").contains(expectedMessage));
    }
}
