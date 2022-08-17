package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogueContent extends Parent{

    public DialogueContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id="mat-input-0")
    private WebElement username;

    @FindBy(id="mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath="(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    WebElement myElement;
    public void findAndSend(String strElement, String value){

        //burada string isimden webelement e ulaşacağım
        switch (strElement)
        {
            case "username" : myElement = username; break;
            case "password" : myElement = password; break;
        }

        sendKeysFunction(myElement, value);

    }

    public void findAndClick(String strElement){

        //burada string isimden webelement e ulaşacağım
        switch (strElement)
        {
            case "loginButton" : myElement = loginButton; break;
        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text){

        //burada string isimden webelement e ulaşacağım
        switch (strElement)
        {
            case "dashboard" : myElement = dashboard; break;
        }

        verifyContainsText(myElement, text);
    }
}
