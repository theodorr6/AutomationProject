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

       WebElement framesField = getWebDriver().findElement(By.xpath("//span[text()='Alerts']"));
        elementMethods.clickElement(framesField);

        AlertPage alertPage = new AlertPage(getWebDriver());
        alertPage.acceptAlert();
        alertPage.dealWithDelayAlert();
        alertPage.dealWithPromptBtn("Test");

    }
}
