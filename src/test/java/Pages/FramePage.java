package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{

    public FramePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement frameElement;

    public void dealWithIFrame(){
        frameMethods.switchSpecificIframe("frame1");
        LoggerUtility.infoTest("The user switches to specific iframe");

        System.out.println(frameElement.getText());
        LoggerUtility.infoTest("The user interacts with frameElement text");

        //specificam sa revina la frame-ul curent
        frameMethods.switchToParentFrame();
        LoggerUtility.infoTest("The user clicks on parent frame");

        frameMethods.switchSpecificIframe("frame2");
        LoggerUtility.infoTest("The user switches to specific iframe");

        System.out.println(frameElement.getText());
        LoggerUtility.infoTest("The user interacts with frameElement text");
    }
}
