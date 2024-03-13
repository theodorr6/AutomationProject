package Pages;

import HelperMethods.ElementMethods;
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
    }

    public void navigateToFramePage(){
        elementMethods.clickElement(framesField);
    }

    public void navigateToWindowPage(){
        elementMethods.clickElement(browserWindowsField);
    }
}
