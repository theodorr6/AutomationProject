package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "alertButton")
    private WebElement clickMeBtn;

    @FindBy(id = "timerAlertButton")
    private WebElement  clickMeBtn2;


    @FindBy(id = "confirmButton")
    private WebElement clickMeBtn3;

    @FindBy(id = "promtButton")
    private WebElement promptAlert;

    public void acceptAlert(){
        elementMethods.clickElement(clickMeBtn);
        LoggerUtility.infoTest("The user clicks on clickMeBtn element");

        alertMethods.acceptAlert();
        LoggerUtility.infoTest("The user accepts alert");
    }

    public void dealWithDelayAlert(){
        elementMethods.clickElement(clickMeBtn2);
        LoggerUtility.infoTest("The user clicks on clickMeBtn2 element");

       // wait explicit
        alertMethods.acceptAlert();
        LoggerUtility.infoTest("The user accepts alert");
    }
    public void dealWithPromptBtn(String text){
        elementMethods.clickElement(promptAlert);
        LoggerUtility.infoTest("The user clicks on promptAlert element");

        alertMethods.fillAlert(text);
        LoggerUtility.infoTest("The user fills alert with: " + text );
    }

}
