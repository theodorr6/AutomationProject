package Tests;

import HelperMethods.ElementMethods;
import ObjectData.PracticeFormObject;
import ObjectData.WebTableObject;
import Pages.FormsPage;
import Pages.HomePage;
import Pages.PracticeFormsPage;
import PropertyUtility.PropertyUtility;
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
        PropertyUtility propertyUtility = new PropertyUtility("PracticeFormData");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateToFormsPage();

        FormsPage formsPage = new FormsPage(getWebDriver());
        formsPage.navigateToPracticeForm();

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getWebDriver());
        practiceFormsPage.fillEntireForm(firstNameFieldValue, lastNameFieldValue, emailFieldValue, mobileNoFieldValue, dobMonthValue, yearValue, dayValue,
                genderValue, hobbies, userSubjectsValue, filePath, addressValue, stateLoc, cityLoc);
        practiceFormsPage.validatePracticeFormTable(firstNameFieldValue,lastNameFieldValue, emailFieldValue, genderValue, mobileNoFieldValue,
                subjectValue, hobbies, filePath, addressValue, stateLoc, cityLoc);
    }
}
