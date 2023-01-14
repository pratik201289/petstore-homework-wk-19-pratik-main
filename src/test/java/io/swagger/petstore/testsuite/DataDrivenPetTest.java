package io.swagger.petstore.testsuite;

import io.swagger.petstore.model.PetPojo;
import io.swagger.petstore.petstoreinfo.PetStoreSteps;
import io.swagger.petstore.petstoreinfo.UserStoreSteps;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@Concurrent(threads = "4x")
@UseTestDataFrom("src/test/java/resources/testdata/PetStorepet.csv")

@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenPetTest extends TestBase {
    static int id;
    static String name;
    static String status;
    static String photoUrl;
    static int id1;
    static String name1;
    static int id2;
    static String name2;

    @Steps
    PetStoreSteps petStoreSteps;
    UserStoreSteps userStoreSteps;
    @Title("Data driven test for multiple pet")
    @Test
    public void createMultiplePet(){
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        ArrayList<PetPojo.TagData> tags  = new ArrayList<>();
        PetPojo.TagData tagData = new PetPojo.TagData(id1,name1);
        tags.add(tagData);
        PetPojo.CategoryData categoryData = new PetPojo.CategoryData(id2,name2);

        petStoreSteps.createNewPetData(id,categoryData,name,photoUrls,tags,status).statusCode(200);

    }



}
