package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DialogueContent extends Parent{

    public DialogueContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id="mat-input-0")
    private WebElement username;

    @FindBy(id="mat-input-1")
    private WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath="(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath="//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath="//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath="//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath="//div[contains(text(),'already exists')]")
    private WebElement alreadyExists;

    @FindBy(xpath="//button[@aria-label='Close dialog']")
    private WebElement closeDialogue;

    @FindBy(xpath="//ms-text-field[contains(@placeholder,'FIELD.NAME')]//input")
    private WebElement searchInput;

    @FindBy(xpath="//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath="//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath="//span[contains(text(),'Delete')]")
    private WebElement deleteDialogueBtn;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath="//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;

    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;

    WebElement myElement;
    public void findAndSend(String strElement, String value){

        switch (strElement)
        {
            case "username" : myElement = username; break;
            case "password" : myElement = password; break;
            case "nameInput" : myElement = nameInput; break;
            case "codeInput" : myElement = codeInput; break;
            case "shortName" : myElement = shortName; break;
            case "searchInput" : myElement =searchInput; break;
            case "integrationCode" : myElement = integrationCode; break;
            case "priorityCode" : myElement = priorityCode; break;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement){

        switch (strElement)
        {
            case "loginButton" : myElement = loginButton; break;
            case "addButton" : myElement = addButton; break;
            case "saveButton" : myElement = saveButton; break;
            case "closeDialogue" : myElement = closeDialogue; break;
            case "searchButton" : myElement =searchButton; break;
            case "deleteButton" : myElement =deleteButton; break;
            case "deleteDialogueBtn" : myElement =deleteDialogueBtn; break;
            case "acceptCookies" : myElement =acceptCookies; break;
        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text){

        switch (strElement)
        {
            case "dashboard" : myElement = dashboard; break;
            case "successMessage" : myElement =successMessage; break;
            case "alreadyExists" : myElement =alreadyExists; break;
        }

        verifyContainsText(myElement, text);
    }

    public void searchAndDelete(String searchText) {

        //scrollUp()
        findAndSend("searchInput", searchText);
        findAndClick("searchButton");

//        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.stalenessOf(deleteButton));

//        waitUntilLoading();
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"),"Search"));

        //    GWD.Bekle(2);  //TODO: incelenecek
        findAndClick("deleteButton");         //silme butonuna tıkla
        findAndClick("deleteDialogueBtn");    //çıkan dialog kutusunda silme butonuna tıkla
    }

}
