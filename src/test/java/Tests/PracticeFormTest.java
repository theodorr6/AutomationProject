package Tests;

import HelperMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        //scrol la pagina
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("window.scrollBy(0,450)", "");

        //identificam un element
        WebElement consentField = getWebDriver().findElement(By.className("fc-button-label"));
        elementMethods.clickElement(consentField);

        WebElement formsField= getWebDriver().findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickElement(formsField);

        WebElement practiceFormField= getWebDriver().findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickElement(practiceFormField);

        WebElement firstNameField= getWebDriver().findElement(By.id("firstName"));
        String firstNameFieldValue="Teo";
        elementMethods.fillElement(firstNameField, firstNameFieldValue);

        js.executeScript("window.scrollBy(0,450)", "");
        WebElement lastNameField= getWebDriver().findElement(By.cssSelector("input[placeholder='Last Name']"));
        String lastNameFieldValue="Virjoghe";
        elementMethods.fillElement(lastNameField, lastNameFieldValue);

        WebElement emailField= getWebDriver().findElement(By.id("userEmail"));
        String emailFieldValue= "test@test.test";
        elementMethods.fillElement(emailField, emailFieldValue);

        WebElement mobileNoField= getWebDriver().findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNoFieldValue= "0123456789";
        elementMethods.fillElement(mobileNoField, mobileNoFieldValue);

        WebElement dobField = getWebDriver().findElement(By.cssSelector(".react-datepicker__input-container"));
        elementMethods.clickElement(dobField);
        WebElement dobMonth = getWebDriver().findElement(By.cssSelector(".react-datepicker__month-select"));
        String dobMonthValue = "July";
        elementMethods.selectTextElement(dobMonth,dobMonthValue);

        WebElement yearField = getWebDriver().findElement(By.cssSelector(".react-datepicker__year-select"));
        String yearValue = "1998";
        elementMethods.selectValueElement(yearField, yearValue);

        List<WebElement> dayDOBFields = getWebDriver().findElements(By.xpath("//div[not(contains(@class, 'outside-month')) and contains(@class, 'react-datepicker__day react-datepicker__day')]"));
        String dayValue = "6";
        for (Integer i = 0; i < dayDOBFields.size(); i++){
            if (dayDOBFields.get(i).getText().equals(dayValue)){
                dayDOBFields.get(i).click();
                break;
            }
        }

        WebElement userGender= getWebDriver().findElement(By.cssSelector("label[for=gender-radio-1"));
        String genderValue = "Male";
        userGender.click();

        // facem un algoritm care sa imi selecteze valorile pe care i le specific
        List<String> hobbies = Arrays.asList("Sports", "Music");
        List<WebElement> hobbiesList = getWebDriver().findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class='custom-control-label']"));
        for (Integer i = 0; i < hobbiesList.size(); i++){
            String currentElementText = hobbiesList.get(i).getText();
            if (hobbies.contains(currentElementText)){
                //hobbiesList.get(i).click();
                js.executeScript("arguments[0].click();", hobbiesList.get(i));
            }
        }

//        WebElement userHobby= webDriver.findElement(By.cssSelector("label[for=hobbies-checkbox-1"));
//        userHobby.click();

        WebElement userSubjects = getWebDriver().findElement(By.id("subjectsInput"));
        String userSubjectsValue = "comp";
        elementMethods.fillPressElement(userSubjects,userSubjectsValue, Keys.ENTER);

        WebElement uploadPicture = getWebDriver().findElement(By.id("uploadPicture"));
        String filePath = "src/test/resources/blur.png";
        elementMethods.fillElement(uploadPicture,new File(filePath).getAbsolutePath());

        WebElement adress = getWebDriver().findElement(By.cssSelector("textarea[placeholder='Current Address']"));
        String adressValue = "oras, strada, numar";
        elementMethods.fillElement(adress, adressValue);

        WebElement selectState = getWebDriver().findElement(By.xpath("//div[text()='Select State']"));
        js.executeScript("arguments[0].click();", selectState);
        String subjectValue = "Computer Science";


       WebElement selectState2 = getWebDriver().findElement(By.id("react-select-3-input"));
       String stateLoc = "NCR";
       elementMethods.fillPressElement(selectState2,stateLoc,Keys.ENTER);

        WebElement selectCity = getWebDriver().findElement(By.xpath("//div[text()='Select City']"));
        js.executeScript("arguments[0].click();", selectCity);

        WebElement selectCity2 = getWebDriver().findElement(By.id("react-select-4-input"));
        String cityLoc = "Delhi";
        elementMethods.fillPressElement(selectCity2, cityLoc, Keys.ENTER);

        WebElement submit = getWebDriver().findElement(By.id("submit"));
        js.executeScript("arguments[0].click()", submit);

        //validam tabelul cu valori
        List<WebElement> labelFields = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[1]"));
        List<WebElement> valuesFields = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[2]"));

        Assert.assertEquals(labelFields.get(0).getText(),"Student Name");
        Assert.assertEquals(valuesFields.get(0).getText(),firstNameFieldValue + " " + lastNameFieldValue);

        Assert.assertEquals(labelFields.get(1).getText(), "Student Email");
        Assert.assertEquals(valuesFields.get(1).getText(), emailFieldValue);

        Assert.assertEquals(labelFields.get(2).getText(), "Gender");
        Assert.assertEquals(valuesFields.get(2).getText(), genderValue);

        Assert.assertEquals(labelFields.get(3).getText(), "Mobile");
        Assert.assertEquals(valuesFields.get(3).getText(), mobileNoFieldValue);

        Assert.assertEquals(labelFields.get(4).getText(), "Date of Birth");
       // Assert.assertEquals(valuesFields.get(4).getText(), );

        Assert.assertEquals(labelFields.get(5).getText(), "Subjects");
        Assert.assertEquals(valuesFields.get(5).getText(), subjectValue);

        Assert.assertEquals(labelFields.get(6).getText(), "Hobbies");
        for (Integer i = 0; i < hobbies.size(); i++) {
            Assert.assertTrue(valuesFields.get(6).getText().contains(hobbies.get(i)));
        }

        Assert.assertEquals(labelFields.get(7).getText(), "Picture");
        String[] arrayFile = filePath.split("/");
        Integer desiredIndex = arrayFile.length -1;
        Assert.assertEquals(valuesFields.get(7).getText(),arrayFile[desiredIndex]);

        // TEMA: de continuat validarile

        Assert.assertEquals(labelFields.get(8).getText(), "Address");
        Assert.assertEquals(valuesFields.get(8).getText(), adressValue);

        Assert.assertEquals(labelFields.get(9).getText(), "State and City");
        Assert.assertEquals(valuesFields.get(9).getText(), stateLoc + " " + cityLoc);


    }
}
