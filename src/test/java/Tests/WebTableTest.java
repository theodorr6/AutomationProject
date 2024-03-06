package Tests;

import HelperMethods.ElementMethods;
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

        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        //scrol la pagina
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0,450)", "");

        //identificam un element
        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
        consentField.click();

        WebElement elementsField= getWebDriver().findElement(By.xpath("//h5[text()='Elements']"));
        elementsField.click();

        js.executeScript("window.scrollBy(0,450)", "");

        WebElement webTablesField= getWebDriver().findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesField.click();

        WebElement addButton= getWebDriver().findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement firstNameField= getWebDriver().findElement(By.id("firstName"));
        String firstNameValue= "Teo";
        elementMethods.fillElement(firstNameField,firstNameValue);


        WebElement lastNameField= getWebDriver().findElement(By.id("lastName"));
        String lastNameValue= "Virjoghe";
        elementMethods.fillElement(lastNameField,lastNameValue);

        WebElement emailField= getWebDriver().findElement(By.id("userEmail"));
        String emailFieldValue= "test@test.test";
        elementMethods.fillElement(emailField, emailFieldValue);

        WebElement ageField= getWebDriver().findElement(By.id("age"));
        String ageFieldValue= "25";
        elementMethods.fillElement(ageField, ageFieldValue);

        WebElement salaryField= getWebDriver().findElement(By.id("salary"));
        String salaryFieldValue= "25";
        elementMethods.fillElement(salaryField, salaryFieldValue);

        WebElement departmentField= getWebDriver().findElement(By.id("department"));
        String departmentFieldValue= "QA";
        elementMethods.fillElement(departmentField, departmentFieldValue);

        WebElement submitButton= getWebDriver().findElement(By.id("submit"));
        submitButton.click();

        //modificam entry-ul adaugat mai sus

        WebElement editButton = getWebDriver().findElement(By.id("edit-record-4"));
        elementMethods.clickElement(editButton);

        WebElement firstNameModifyField= getWebDriver().findElement(By.id("firstName"));
        String firstNameModifyValue= "Teodor";
        elementMethods.refillElement(firstNameModifyField, firstNameModifyValue);


        WebElement ageModifyField= getWebDriver().findElement(By.id("age"));
        String ageModifyFieldValue= "26";
        elementMethods.refillElement(ageModifyField, ageModifyFieldValue);

        WebElement submitModifyButton= getWebDriver().findElement(By.id("submit"));
        elementMethods.clickElement(submitModifyButton);

        //stergem entry-ul
        WebElement deleteButton= getWebDriver().findElement(By.id("delete-record-4"));
        elementMethods.clickElement(deleteButton);


        //inchidem un browser = quit()
        //inchidem un tab = close()
        getWebDriver().quit();
    }
}
