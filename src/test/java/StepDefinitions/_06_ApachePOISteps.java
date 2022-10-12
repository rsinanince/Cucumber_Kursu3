package StepDefinitions;

import Pages.DialogueContent;
import Pages.FormContent;
import Pages.LeftNav;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class _06_ApachePOISteps {

    LeftNav leftNav=new LeftNav();
    DialogueContent dialogueContent=new DialogueContent();
    FormContent formContent=new FormContent();
    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        //excelden oku ve citizenship i create et

        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                        "testCitizen", 2);
        for (ArrayList<String> satir : tablo)
        {
            dialogueContent.findAndClick("addButton");
            dialogueContent.findAndSend("nameInput",satir.get(0));
            dialogueContent.findAndSend("shortName",satir.get(1));
            dialogueContent.findAndClick("saveButton");
            dialogueContent.findAndContainsText("successMessage", "success");
        }
    }

    @Then("User delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        //kaydettiklerini yine excel den okuyarak sil

        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx",
                        "testCitizen", 1);
        for (ArrayList<String> satir : tablo)
        {
            System.out.println("satir = " + satir);
            System.out.println("satir.get(0) = " + satir.get(0));

            dialogueContent.searchAndDelete(satir.get(0));
            dialogueContent.findAndContainsText("successMessage", "success");
        }


    }
}
