package io.swagger.petstore.testsuite;

import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagWithUserRunner extends TestBase {
    @WithTag("UserFeature:POSITIVE")
    @Title("Provide 200 code when post data")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .post("/user")
                .then()
                .statusCode(415)
                .log().all();
    }
    @WithTags({
            @WithTag("Userfeature:Sanity"),
            @WithTag("UserFeature:NEGETIVE")
    })
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/user")
                .then()
                .statusCode(405)
                .log().all();
    }
    @WithTags({
            @WithTag("Userfeature:Sanity"),
            @WithTag("UserFeature:NEGETIVE")
    })
    @Title("This test will provide an error code of 400 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/user125")
                .then()
                .statusCode(404)
                .log().all();
    }
}
