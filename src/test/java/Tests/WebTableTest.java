package Tests;

import HelperMethods.ElementMethods;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.WebTablePage;
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
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToElementsPage();

        ElementsPage elementsPage = new ElementsPage(getWebDriver());
        elementsPage.navigateToWebTablePage();

        String firstNameValue= "Teo";
        String lastNameValue= "Virjoghe";
        String emailFieldValue= "test@test.test";
        String ageFieldValue= "25";
        String salaryFieldValue= "25";
        String departmentFieldValue= "QA";
        String firstNameModifyValue= "Teodor";
        String ageModifyFieldValue= "26";

        WebTablePage webTablePage = new WebTablePage(getWebDriver());
        webTablePage.addNewEntry(firstNameValue, lastNameValue, emailFieldValue, ageFieldValue, salaryFieldValue,departmentFieldValue);
        webTablePage.editEntry(firstNameModifyValue, ageModifyFieldValue);
        webTablePage.deleteEntry();

    }
}
