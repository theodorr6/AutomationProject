package Pages;

import HelperMethods.ElementMethods;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

//    @FindBy(className = "fc-button-label")
//    private WebElement consentField;
    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsField;
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsField;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsField;



    public void navigateToAlertFrameWindowPage(){
        elementMethods.scrollElementByPixel(0,450);
        LoggerUtility.infoTest("The user scrolls down the page");
      //  elementMethods.clickElement(consentField);
        elementMethods.clickElement(alertsField);
        LoggerUtility.infoTest("The user clicks on alertsField element");
    }

    public void navigateToFormsPage(){
        elementMethods.scrollElementByPixel(0,450);
        LoggerUtility.infoTest("The user scrolls down the page");
        elementMethods.clickElement(formsField);
        LoggerUtility.infoTest("The user clicks on formsField element");
    }

    public void navigateToElementsPage(){
        elementMethods.scrollElementByPixel(0, 450);
        LoggerUtility.infoTest("The user scrolls down the page");
        elementMethods.clickElement(elementsField);
        LoggerUtility.infoTest("The user clicks on elementsField element");
    }
}
