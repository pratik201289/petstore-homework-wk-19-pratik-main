package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.petstoreinfo.UserStoreSteps;
import io.swagger.petstore.testbase.TestBase;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;

public class UserEndpointSteps extends TestBase {
    static int id = 8;
    static String username= "patnaugh";
    static String firstName= "Pratik";
    static String lastName= "Vyas";
    static String email = "pvyas123m@gmail" + TestUtils.getRandomValue();
    static String password= "password2";
    static String phone= "07404835155";
    static int userStatus= 121;
    static ValidatableResponse response ;
    @Steps
    UserStoreSteps userStoreSteps;

    @When("^I create a user$")
    public void iCreateAUser() {
        response = userStoreSteps.createNewUser(id,username,firstName,lastName,email,password,phone,userStatus);
    }

    @Then("^I must get back a valid status code$")
    public void iMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I send a get request to user using username endpoint$")
    public void iSendAGetRequestToUserUsingUsernameEndpoint() {
        response = userStoreSteps.getUserByUserName(username);
    }


    @Then("^I must have valid status code 200$")
    public void iMustHaveValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I update a user with name$")
    public void iUpdateAUserWithName() {
        firstName ="Katie";
        response = userStoreSteps.updateUser(id,username,firstName,lastName,email,password,phone,userStatus);

    }

    @Then("^I verify with endpoint by username and validate status$")
    public void iVerifyWithEndpointByUsernameAndValidateStatus() {
        response = userStoreSteps.getUserByUserName(username);
        response.statusCode(200);
    }

    @When("^I delete a user with endpoint of username$")
    public void iDeleteAUserWithEndpointOfUsername() {
       response= userStoreSteps.deleteUser(username);
    }

    @Then("^I must get valid response of deleted user$")
    public void iMustGetValidResponseOfDeletedUser() {
        response.statusCode(200);
    }
}

