package TestCases;

import utilis.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    String Email = "maark.hny@gmail.com";
    String Password = "123456";

    String INVALID_EMAIL ="mark@invalid.com";
    String INVALID_PASSWORD = "123321";

//    String expectedMessage =
//            Utils.JsonHelper.getValueFromJson(
//                    "src/main/resources/TestData/ExpectedResults.json", "userCreatedMessage");
    String EXPECTED_RESULTS_FILE =
            "src/main/resources/TestData/ExpectedMessages.json";

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI =
                ConfigReader.getProperty("baseUrl");

    }
}
