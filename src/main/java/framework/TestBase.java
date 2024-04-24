package framework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import util.PropertyFileReader;

import static framework.Constants.COLON_DOUBLE_SLASH;
import static io.restassured.RestAssured.given;

public class TestBase {

    public static RequestSpecification requestSpecification = null;
    public SoftAssert softAssert;

    @BeforeClass
    public void initialiseAssertions() {
        softAssert = new SoftAssert();
    }

    @BeforeClass
    public static RequestSpecification sendApiRequest() {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(PropertyFileReader.getProperty("API_PROTOCOL") + COLON_DOUBLE_SLASH + PropertyFileReader
                        .getProperty("API_HOST"))
                .addHeader("Accept", "application/json")
                .setRelaxedHTTPSValidation()
                .build();
        return given().spec(requestSpecification).when().log().all();
    }

}
