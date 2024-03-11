package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.FrameMethods;
import Pages.AlertWindowFramePage;
import Pages.FramePage;
import Pages.HomePage;
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

        //identificam un element
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToFramePage();

        FramePage framePage = new FramePage(getWebDriver());
        framePage.dealWithIFrame();

    }
}
