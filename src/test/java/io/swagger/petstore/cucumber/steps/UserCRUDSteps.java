package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.petstoreinfo.UserStoreSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class UserCRUDSteps {
    static ValidatableResponse response;
   static String firstName = null;
    static int userId;

    @Steps
    UserStoreSteps userStoreSteps;
    @Given("^Pet store Application running$")
    public void petStoreApplicationRunning() {
    }

    @When("^I create new user by providing the information id \"([^\"]*)\" username \"([^\"]*)\" firstName\"([^\"]*)\" lastName \"([^\"]*)\"  email \"([^\"]*)\" password\"([^\"]*)\" phone \"([^\"]*)\"userStatus \"([^\"]*)\"$")
    public void iCreateNewUserByProvidingTheInformationIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatus(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus)  {

        response = userStoreSteps.createNewUser(id,username,firstName,lastName,email,password,phone,userStatus).statusCode(200);
    }
    @Then("^I get that created user  with \"([^\"]*)\" is created$")
    public void iGetThatCreatedUserWithIsCreated(String username) {
        response.log().all().statusCode(200);
        response = userStoreSteps.getUserByUserName(username);
        HashMap<String, Object> userMap = response.extract().path("");
        Assert.assertThat(userMap, hasValue(username));
    }

    @And("^I update the user with information  id \"([^\"]*)\" username \"([^\"]*)\" firstName\"([^\"]*)\" lastName \"([^\"]*)\"  email \"([^\"]*)\" password\"([^\"]*)\" phone \"([^\"]*)\"userStatus \"([^\"]*)\"$")
    public void iUpdateTheUserWithInformationIdUsernameFirstNameLastNameEmailPasswordPhoneUserStatus(int id, String username, String firstName1, String lastName, String email, String password, String phone, int userStatus)
    {
        firstName ="Manan";
       response = userStoreSteps.updateUser(id,username,firstName,lastName,email,password,phone,userStatus).statusCode(200);
    }

    @And("^I verify user updated with \"([^\"]*)\" successfully$")
    public void iVerifyUserUpdatedWithSuccessfully(String username)  {
        response.log().all().statusCode(200);
        response = userStoreSteps.getUserByUserName(username);
        HashMap<String, Object> userMap = response.extract().path("");
        Assert.assertThat(userMap, hasValue(username));

    }

    @And("^I delete created user with username \"([^\"]*)\"$")
    public void iDeleteCreatedUserWithUsername(String username)  {
        userStoreSteps.deleteUser(username).log().all().statusCode(200);
    }

    @Then("^The user deleted successfully$")
    public void theUserDeletedSuccessfully() {
    }



}
