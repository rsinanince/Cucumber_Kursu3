package StepDefinitions;

import Pages.DialogueContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _02_CountrySteps {

    LeftNav ln=new LeftNav();
    DialogueContent dc= new DialogueContent();
    @And("Navigate to country page")
    public void navigateToCountryPage() {

        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("countries");
    }

    @When("Create a country")
    public void createACountry() {

        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", "ulke1158");
        dc.findAndSend("codeInput", "1169");
        dc.findAndClick("saveButton");

    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage", "success");

    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String arg0, String arg1) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", arg0);
        dc.findAndSend("codeInput", arg1);
        dc.findAndClick("saveButton");

    }
}
