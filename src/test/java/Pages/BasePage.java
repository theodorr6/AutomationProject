package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethods;
import HelperMethods.FrameMethods;
import HelperMethods.WindowMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected ElementMethods elementMethods;
    protected AlertMethods alertMethods;
    protected WebDriver webDriver;
    protected FrameMethods frameMethods;
    protected WindowMethods windowMethods;


    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        elementMethods = new ElementMethods(webDriver);
        alertMethods = new AlertMethods(webDriver);
        frameMethods = new FrameMethods(webDriver);
        windowMethods = new WindowMethods(webDriver);
        PageFactory.initElements(webDriver,this);
    }
}
