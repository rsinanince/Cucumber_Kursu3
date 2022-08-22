package StepDefinitions;

import Pages.DialogueContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    DialogueContent dc=new DialogueContent();
    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        LeftNav ln=new LeftNav();
        ln.findAndClick("setupOne");  //bunları countrysteps ten aldık
        ln.findAndClick("parameters"); //bunları countrysteps ten aldık
        ln.findAndClick("citizenship");  //sadece bu locator tanımlanacak. diğer ikisi tanımlı zaten
    }

    @When("User a Citizenship name as {string} short name as {string}")
    public void userACitizenshipNameAsShortNameAs(String arg0, String shortName) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", arg0);
        dc.findAndSend("shortName", shortName);
        dc.findAndClick("saveButton");
    }

    @Then("Already exists message should be displayed")
    public void alreadyExistsMessageShouldBeDisplayed()
    {
        dc.findAndContainsText("alreadyExists", "already exists");
    }

    @And("Click on close button")
    public void clickOnCloseButton()
    {
        dc.findAndClick("closeDialogue");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String arananKelime) {
        dc.searchAndDelete(arananKelime);
    }

}
