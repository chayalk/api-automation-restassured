package com.api.tests.name;

import framework.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

public class NameResourceTest extends TestBase {

    @Test(description = "Test case #1: Verify all usernames are listed")
    public void testAllUserNamesAreListed() {

        String path = "users";
        int expectedUserNameList = 10;

        Response response = sendApiRequest().get(path);
        response.prettyPeek();
        softAssert.assertEquals(response.getStatusCode(), SC_OK, "Status code is invalid");

        List<String> userNameIds = response.jsonPath().getList("id");
        int actualListSize = userNameIds.size();

        softAssert.assertEquals(actualListSize, expectedUserNameList);
        softAssert.assertAll();
    }
}
