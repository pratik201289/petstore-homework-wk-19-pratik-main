package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.petstoreinfo.PetStoreSteps;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;

public class PetEndPointSteps {
    static ValidatableResponse response;
    static PetPojo.CategoryData categoryData;
    ArrayList<PetPojo.TagData> tags;
    static String photoUrl = "netplanet@co.uk";
    static int idFirst =5;
    static int idsecond =10;
    static String nameFirst ="Tesla";
    static String namesecond ="Chickenpox";
    static int id =21;
    static String name ="Lola";
    static String status = "Available";
    static int pet;

    @Steps
    PetStoreSteps petStoreSteps;
    @When("^I create a pet with  endpoint id$")
    public void iCreateAPetWithEndpoint() {
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        tags  = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(idFirst,nameFirst);
        tags.add(tagData);
        categoryData = new PetPojo.CategoryData(idsecond,namesecond);

       response= petStoreSteps.createNewPetData(id,categoryData,name,photoUrls,tags,status);
    }

    @Then("^I must get back a valid status code 200$")
    public void iMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I send a get request to pet using petId endpoint$")
    public void iSendAGetRequestToPetUsingPetIdEndpoint() {
        response= petStoreSteps.getPetDetailById(id);
    }

    @Then("^I must get single pet data$")
    public void iMustGetSinglePetData() {
        response.statusCode(200);
    }
    @When("^I update a pet with name$")
    public void iUpdateAPetWithName() {
        name = "Doggie";
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        tags  = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(idFirst,nameFirst);
        tags.add(tagData);
        categoryData = new PetPojo.CategoryData(idsecond,namesecond);
        response=   petStoreSteps.updatePetById(id,categoryData,name,photoUrls,tags,status);
    }

    @Then("^I verify with endpoint pet id$")
    public void iVerifyWithEndpointPetId() {
        response.statusCode(200);
//        HashMap<String,Object> petId = response.extract().path("");
//        pet= (int) petId.get("id");
//        Assert.assertThat(petId, hasValue(name));
    }


    @When("^I delete a pet with endpoint of id$")
    public void iDeleteAPetWithEndpointOfId() {
      response=  petStoreSteps.deletePetById(id);

    }

    @Then("^I must get valid response$")
    public void iMustGetValidResponse() {
        response.statusCode(200);
    }


}
