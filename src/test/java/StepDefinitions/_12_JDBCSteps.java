package StepDefinitions;

import Pages.DialogueContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _12_JDBCSteps {
    @Then("Send the query to database {string} and control match")
    public void sendTheQueryToDatabaseAndControlMatch(String query) {
        //DBden gerekli liste alınacak
        List<List<String>> dbList= DBUtility.getListData(query);
        System.out.println("dbList = " + dbList);

        //webden ekrandaki isimler alınacak
        DialogueContent dc=new DialogueContent();
        List <WebElement> uiList = dc.waitVisibleListAllElement(dc.nameList);
        for (WebElement e: uiList)
            System.out.println("e.getText() = " + e.getText());

        //karşılaştırılacak
        for (int i=0; i< dbList.size(); i++)
            Assert.assertEquals("Hatalı durum",dbList.get(i).get(1), uiList.get(i).getText());


    }
}
