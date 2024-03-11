package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementMethods;
import Pages.AlertPage;
import Pages.AlertWindowFramePage;
import Pages.HomePage;
import SharedData.SharedData;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AlerteTest extends SharedData {


    @Test
    public void alertMethod(){

        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        AlertMethods alertMethods = new AlertMethods(getWebDriver());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToAlertPage();

        WebElement framesField= getWebDriver().findElement(By.xpath("//span[text()='Alerts']"));
        elementMethods.clickElement(framesField);

        AlertPage alertPage = new AlertPage(getWebDriver());
        alertPage.acceptAlert();
        alertPage.dealWithDelayAlert();
        alertPage.dealWithPromptBtn("Test");

//        WebElement clickMeBtn = getWebDriver().findElement(By.id("alertButton"));
//        elementMethods.clickElement(clickMeBtn);
//        alertMethods.acceptAlert();
//
//        WebElement clickMeBtn2 = getWebDriver().findElement(By.id("timerAlertButton"));
//        elementMethods.clickElement(clickMeBtn2);
//
//        // wait explicit
//        alertMethods.acceptAlert();
//
//        WebElement clickMeBtn3 = getWebDriver().findElement(By.id("confirmButton"));
//        elementMethods.clickElement(clickMeBtn3);
//        alertMethods.acceptAlert();
//
//
//        WebElement promptAlert = getWebDriver().findElement(By.id("promtButton"));
//        elementMethods.clickElement(promptAlert);
//        alertMethods.fillAlert("Test");

//        List<WebElement> alertText = getWebDriver().findElements(By.xpath("//div/div/span[@class='mr-3']"));
//        List<WebElement> alertConfirmation = getWebDriver().findElements(By.xpath("//div/div/span[@class='text-success']"));
//
//        Assert.assertEquals(alertText.get(2).getText(), "On button click, confirm box will appear");
//        Assert.assertEquals(alertConfirmation.get(0).getText(), "You selected Ok");
//
//        Assert.assertEquals(alertText.get(3).getText(), "On button click, prompt box will appear");
//        Assert.assertEquals(alertConfirmation.get(1).getText(), "You entered Test");
    }
}
