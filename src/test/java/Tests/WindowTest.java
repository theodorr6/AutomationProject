package Tests;

import HelperMethods.ElementMethods;
import HelperMethods.WindowMethods;
import Pages.AlertWindowFramePage;
import Pages.HomePage;
import Pages.WindowPage;
import SharedData.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends Hooks {

    @Test
    public void windowMethod(){
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(getWebDriver());
        alertWindowFramePage.navigateToWindowPage();

        WindowPage windowPage = new WindowPage(getWebDriver());
        windowPage.interactWithTabBrowser();
        windowPage.interactNewWindow();
    }
}
