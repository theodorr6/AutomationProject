package Pages;

import HelperMethods.ElementMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertWindowFramePage extends BasePage {

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertField;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesField;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowsField;

    public AlertWindowFramePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToAlertPage(){

        elementMethods.clickElement(alertField);
        LoggerUtility.infoTest("The user clicks on alertField element");
    }

    public void navigateToFramePage(){
        elementMethods.clickElement(framesField);
        LoggerUtility.infoTest("The user clicks on framesField element");
    }

    public void navigateToWindowPage(){
        elementMethods.clickElement(browserWindowsField);
        LoggerUtility.infoTest("The user clicks on browserWindowsField element");
    }
}
