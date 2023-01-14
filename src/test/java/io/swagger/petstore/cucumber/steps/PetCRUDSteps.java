package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.petstoreinfo.PetStoreSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class PetCRUDSteps {
    static String name = null;
    static int pet;
    static ValidatableResponse response;
    static PetPojo.CategoryData categoryData;
    ArrayList<PetPojo.TagData> tags;
    static int id;
    @Steps
    PetStoreSteps petStoreSteps;

    @Given("^Pet store creating new pet data$")
    public void petStoreCreatingNewPetData() {
    }
    @When("^I create a new pet by providing the information id \"([^\"]*)\" idFirst \"([^\"]*)\" name \"([^\"]*)\" nameFirst \"([^\"]*)\" photoUrl\"([^\"]*)\"idsecond \"([^\"]*)\" namesecond \"([^\"]*)\" status\"([^\"]*)\"$")
    public void iCreateANewPetByProvidingTheInformationIdIdFirstNameNameFirstPhotoUrlIdsecondNamesecondStatus(int id, int idFirst, String name1, String nameFirst, String photoUrl, int idsecond, String namesecond, String status)  {

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        tags  = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(idFirst,nameFirst);
        tags.add(tagData);
        categoryData = new PetPojo.CategoryData(idsecond,namesecond);

        petStoreSteps.createNewPetData(id,categoryData,name,photoUrls,tags,status).statusCode(200);

    }



    @Then("^I verify A pet with \"([^\"]*)\" is created$")
    public void iVerifyAPetWithIsCreated(int id)  {

        ValidatableResponse response= petStoreSteps.getPetDetailById(id);
        response.log().all().statusCode(200);


    }

    @And("^I update the pet information  id \"([^\"]*)\" idFirst \"([^\"]*)\" name \"([^\"]*)\" nameFirst \"([^\"]*)\" photoUrl\"([^\"]*)\"idsecond \"([^\"]*)\" namesecond \"([^\"]*)\" status\"([^\"]*)\"$")
    public void iUpdateThePetInformationIdIdFirstNameNameFirstPhotoUrlIdsecondNamesecondStatus(int id, int idFirst, String name1, String nameFirst, String photoUrl, int idsecond, String namesecond, String status)

    {
        name = "Doggie";
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        tags  = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(idFirst,nameFirst);
        tags.add(tagData);
        categoryData = new PetPojo.CategoryData(idsecond,namesecond);
        response=   petStoreSteps.updatePetById(id,categoryData,name,photoUrls,tags,status).statusCode(200);
    }

    @And("^A pet update with \"([^\"]*)\" is successfully$")
    public void aPetUpdateWithIsSuccessfully(String name1) {
        response.statusCode(200);
       HashMap<String,Object> petId = response.extract().path("");
       pet= (int) petId.get("id");
        Assert.assertThat(petId, hasValue(name));

    }

    @And("^I delete the pet that created with \"([^\"]*)\"$")
    public void iDeleteThePetThatCreatedWith(int id)  {

        petStoreSteps.deletePetById(id);

    }

    @Then("^the pet deleted succesfully from the application$")
    public void thePetDeletedSuccesfullyFromTheApplication() {
        response.statusCode(200);
        petStoreSteps.getPetDetailById(id).statusCode(404);
    }



}
