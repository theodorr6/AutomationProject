package Pages;

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
        alertMethods.acceptAlert();
    }

    public void dealWithDelayAlert(){
        elementMethods.clickElement(clickMeBtn2);
       // wait explicit
        alertMethods.acceptAlert();
    }
    public void dealWithPromptBtn(String text){
        elementMethods.clickElement(promptAlert);
        alertMethods.fillAlert(text);
    }
}
