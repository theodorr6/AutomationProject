package Tests;

import HelperMethods.ElementMethods;
import Pages.FormsPage;
import Pages.HomePage;
import Pages.PracticeFormsPage;
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
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToFormsPage();

        FormsPage formsPage = new FormsPage(getWebDriver());
        formsPage.navigateToPracticeForm();

        String firstNameFieldValue="Teo";
        String lastNameFieldValue="Virjoghe";
        String emailFieldValue= "test@test.test";
        String mobileNoFieldValue= "0123456789";
        String dobMonthValue = "July";
        String yearValue = "1998";
        String dayValue = "6";
        String genderValue = "Male";
        List<String> hobbies = Arrays.asList("Sports", "Music");
        String userSubjectsValue = "comp";
        String filePath = "src/test/resources/blur.png";
        String addressValue = "oras, strada, numar";
        String subjectValue = "Computer Science";
        String stateLoc = "NCR";
        String cityLoc = "Delhi";

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getWebDriver());
        practiceFormsPage.fillFirstName(firstNameFieldValue);
        practiceFormsPage.fillLastName(lastNameFieldValue);
        practiceFormsPage.fillEmailField(emailFieldValue);
        practiceFormsPage.fillMobileNoField(mobileNoFieldValue);
        practiceFormsPage.pickBirthDate(dobMonthValue, yearValue, dayValue);
        practiceFormsPage.pickGender(genderValue);
        practiceFormsPage.pickHobbies(hobbies);
        practiceFormsPage.pickSubjects(userSubjectsValue);
        practiceFormsPage.uploadPicture(filePath);
        practiceFormsPage.pickAddress(addressValue);
        practiceFormsPage.pickState(stateLoc);
        practiceFormsPage.pickCity(cityLoc);
        practiceFormsPage.clickSubmit();

//
//        //validam tabelul cu valori
//        List<WebElement> labelFields = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[1]"));
//        List<WebElement> valuesFields = getWebDriver().findElements(By.xpath("//table/tbody/tr/td[2]"));
//
//        Assert.assertEquals(labelFields.get(0).getText(),"Student Name");
//        Assert.assertEquals(valuesFields.get(0).getText(),firstNameFieldValue + " " + lastNameFieldValue);
//
//        Assert.assertEquals(labelFields.get(1).getText(), "Student Email");
//        Assert.assertEquals(valuesFields.get(1).getText(), emailFieldValue);
//
//        Assert.assertEquals(labelFields.get(2).getText(), "Gender");
//        Assert.assertEquals(valuesFields.get(2).getText(), genderValue);
//
//        Assert.assertEquals(labelFields.get(3).getText(), "Mobile");
//        Assert.assertEquals(valuesFields.get(3).getText(), mobileNoFieldValue);
//
//        Assert.assertEquals(labelFields.get(4).getText(), "Date of Birth");
//       // Assert.assertEquals(valuesFields.get(4).getText(), );
//
//        Assert.assertEquals(labelFields.get(5).getText(), "Subjects");
//        Assert.assertEquals(valuesFields.get(5).getText(), subjectValue);
//
//        Assert.assertEquals(labelFields.get(6).getText(), "Hobbies");
//        for (Integer i = 0; i < hobbies.size(); i++) {
//            Assert.assertTrue(valuesFields.get(6).getText().contains(hobbies.get(i)));
//        }
//
//        Assert.assertEquals(labelFields.get(7).getText(), "Picture");
//        String[] arrayFile = filePath.split("/");
//        Integer desiredIndex = arrayFile.length -1;
//        Assert.assertEquals(valuesFields.get(7).getText(),arrayFile[desiredIndex]);
//
//        // TEMA: de continuat validarile
//
//        Assert.assertEquals(labelFields.get(8).getText(), "Address");
//        Assert.assertEquals(valuesFields.get(8).getText(), adressValue);
//
//        Assert.assertEquals(labelFields.get(9).getText(), "State and City");
//        Assert.assertEquals(valuesFields.get(9).getText(), stateLoc + " " + cityLoc);


    }
}
