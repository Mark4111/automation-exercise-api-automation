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
public class TestCase2 extends BaseTest {

    @Story("POST To All Products List")
    @Description("Verify that sending a POST request to products list endpoint returns response code 405 and the appropriate error message")
    @Test
    public void TC2_POSTToAllProductsList(){
        Response response = given()
                .when().post(ConfigReader.getProperty("productsList"));
        // Print response
        response.then().log().all();
        //Status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response Code from JSON Body
        AssertionsHelper.assertResponseCode(response,405);
        //Response Msg

        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "methodNotSupportedMessage");

        Assert.assertEquals(response.jsonPath().getString("message"),expectedMessage);
    }
}
