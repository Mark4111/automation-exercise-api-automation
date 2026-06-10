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
public class TestCase5 extends BaseTest{
    @Story("Search Product")
    @Description("Verify that search product API returns results when valid search term is provided")
    @Test
    public void TC5_PostToSearchProduct(){
        Response response = given()
                .param("search_product","top")
                .when().post(ConfigReader.getProperty("searchProduct"));
        //print response
        response.then().log().all();
        //Status Code
        AssertionsHelper.assertStatusCode(response,200);
        //Response code in json
        AssertionsHelper.assertResponseCode(response,200);
        //assert for response body
        Assert.assertTrue(response.jsonPath().getList("products").size()>0);
    }
}
