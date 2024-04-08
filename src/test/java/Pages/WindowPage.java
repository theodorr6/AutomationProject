package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowPage extends BasePage{

    public WindowPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "tabButton")
    private WebElement newTabButton;
    @FindBy(id = "windowButton")
    private WebElement newWindowButton;

    public void interactWithTabBrowser(){
        elementMethods.clickElement(newTabButton);
        LoggerUtility.infoTest("The user clicks on newTabButton");

        windowMethods.switchSpecificTabWindow(1);
        LoggerUtility.infoTest("The user switches focus to tab index 1");

        windowMethods.closeCurrentTabWindow();
        LoggerUtility.infoTest("The user closes current tab");

        windowMethods.switchSpecificTabWindow(0);
        LoggerUtility.infoTest("The user switches focus to tab index 0");
    }

    public void interactNewWindow(){
        elementMethods.clickElement(newWindowButton);
        LoggerUtility.infoTest("The user clicks on newWindowButton element");

        windowMethods.switchSpecificTabWindow(1);
        LoggerUtility.infoTest("The user switches focus to window index 1");

        windowMethods.closeCurrentTabWindow();
        LoggerUtility.infoTest("The user closes current window");

        windowMethods.switchSpecificTabWindow(0);
        LoggerUtility.infoTest("The user switches focus to window index 0");

    }

}
