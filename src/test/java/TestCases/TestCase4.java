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
public class TestCase4 extends BaseTest{
    @Story("PUT to all brands list")
    @Description("Verify that sending a PUT request to brands list endpoint returns response code 405 and the appropriate error message")
    @Test
    public void TC4_PUTToAllBrandsList()
    {
        Response response = given()
                .when().put(ConfigReader.getProperty("brandsList"));
        //print response
        response.then().log().all();
        //status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,405);
        //response msg
        String expectedMessage = Utils.JsonHelper.getValueFromJson(EXPECTED_RESULTS_FILE, "methodNotSupportedMessage");
        Assert.assertEquals(response.jsonPath().getString("message"),expectedMessage);
    }
}
