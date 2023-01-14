package io.swagger.petstore.testsuite;

import io.swagger.petstore.petstoreinfo.UserStoreSteps;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/java/resources/testdata/PetstoreUser.csv")

@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenUserTest extends TestBase {
    //for user create data driven
    static int id;
    static String username;
    static String firstName;
    static String lastName;
    static String email;
    static String password;
    static String phone;
    static int userStatus;
    @Steps
    UserStoreSteps userStoreSteps;

    @Title("data driven test for multiple user create")
    @Test
    public void createMultipleUser() {
        userStoreSteps.createNewUser(id, username, firstName, lastName, email, password, phone, userStatus).statusCode(200);
    }
}
