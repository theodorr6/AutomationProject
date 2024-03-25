package Tests;

import HelperMethods.ElementMethods;
import ObjectData.WebTableObject;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.WebTablePage;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest(){
        PropertyUtility propertyUtility = new PropertyUtility("WebTableData");
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToElementsPage();

        ElementsPage elementsPage = new ElementsPage(getWebDriver());
        elementsPage.navigateToWebTablePage();

        WebTablePage webTablePage = new WebTablePage(getWebDriver());
        webTablePage.addNewEntry(webTableObject);

        webTableObject.setFirstNameValue("Teodor");
        webTableObject.setAgeFieldValue("25");

        webTablePage.editEntry(webTableObject);
        webTablePage.deleteEntry();

    }
}
