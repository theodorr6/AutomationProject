package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.FrameMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.swing.text.Element;

public class FrameTest extends SharedData {


    @Test
    public void frameMethod(){
        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        FrameMethods frameMethods = new FrameMethods(getWebDriver());

        elementMethods.scrollElementByPixel(0, 450);

        //identificam un element
        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
        elementMethods.clickElement(consentField);

        WebElement alertsField= getWebDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementMethods.clickElement(alertsField);

        WebElement framesField= getWebDriver().findElement(By.xpath("//span[text()='Frames']"));
        elementMethods.clickElement(framesField);

        // interactionam cu un iFrame
        frameMethods.switchSpecificIframe("frame1");


       // WebElement frame1Element = webDriver.findElement(By.id("sampleHeading"));
        //specificam sa revina la frame-ul curent
        frameMethods.switchToParentFrame();


        frameMethods.switchSpecificIframe("frame2");
      //  WebElement frame2Element = webDriver.findElement(By.id("sampleHeading"));

    }
}
