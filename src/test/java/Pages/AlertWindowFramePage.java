package Pages;

import HelperMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertWindowFramePage extends BasePage {

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement framesField;

    public AlertWindowFramePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToAlertPage(){

        elementMethods.clickElement(framesField);
    }
}
