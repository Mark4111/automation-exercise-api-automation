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
@Feature("Products API")
public class TestCase1 extends BaseTest{

    @Story("Get All Products")
    @Description("Verify that the products list endpoint returns status code 200 and a non-empty products list")
    @Test
    public void TC1_GetAllProductsList(){
        Response response = given()
                            .when().get(ConfigReader.getProperty("productsList"));
        // Print response
        response.then().log().all();
        //status code
        AssertionsHelper.assertStatusCode(response, 200);
        //responseCode inside JSON
        AssertionsHelper.assertResponseCode(response, 200);
        //products list is not empty
        Assert.assertFalse(response.jsonPath().getList("products").isEmpty());
    }
}
