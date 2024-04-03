package Pages;

import ObjectData.PracticeFormObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormsPage extends  BasePage{
    public PracticeFormsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameField;
    @FindBy(id = "userEmail")
    private WebElement emailField;
    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement mobileNoField;
    @FindBy(css = ".react-datepicker__input-container")
    private WebElement dobField;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement dobMonth;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearField;
    @FindBy(xpath = "//div[not(contains(@class, 'outside-month')) and contains(@class, 'react-datepicker__day react-datepicker__day')]")
    private List<WebElement> dayDOBFields;
    @FindBy(css = "label[for=gender-radio-1")
    private WebElement userGender;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> hobbiesList;
    @FindBy(id = "subjectsInput")
    private WebElement userSubjects;
    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;
    @FindBy(css = "textarea[placeholder='Current Address']")
    private WebElement adress;
    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement selectState;
    @FindBy(id = "react-select-3-input")
    private WebElement selectState2;
    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement selectCity;
    @FindBy(id = "react-select-4-input")
    private WebElement selectCity2;
    @FindBy(id = "submit")
    private WebElement submit;
    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> labelFields;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> valuesFields;


    public void fillFirstName(String firstNameFieldValue){
        elementMethods.fillElement(firstNameField, firstNameFieldValue);
        elementMethods.scrollElementByPixel(0, 450);
    }

    public void fillLastName(String lastNameFieldValue){
        elementMethods.fillElement(lastNameField, lastNameFieldValue);
    }

    public void fillEmailField(String emailFieldValue){
        elementMethods.fillElement(emailField, emailFieldValue);
    }

    public void fillMobileNoField(String mobileNoFieldValue){
        elementMethods.fillElement(mobileNoField, mobileNoFieldValue);
    }

    public void pickBirthDate(String dobMonthValue, String yearValue, String dayValue){
        elementMethods.clickElement(dobField);
        elementMethods.selectTextElement(dobMonth,dobMonthValue);
        elementMethods.selectValueElement(yearField, yearValue);

        for (Integer i = 0; i < dayDOBFields.size(); i++){
            if (dayDOBFields.get(i).getText().equals(dayValue)){
                dayDOBFields.get(i).click();
                break;
            }
        }
    }

    public void pickGender(String genderValue){
        userGender.click();
    }

    public void pickHobbies(List<String> hobbies){
        for (Integer i = 0; i < hobbiesList.size(); i++){
            String currentElementText = hobbiesList.get(i).getText();
            if (hobbies.contains(currentElementText)){
                //hobbiesList.get(i).click();
                elementMethods.clickElemForce(hobbiesList.get(i));
            }
        }
    }

    public void pickSubjects(String userSubjectsValue){
        elementMethods.fillPressElement(userSubjects,userSubjectsValue, Keys.ENTER);
    }

    public void uploadPicture(String filePath){
        elementMethods.fillElement(uploadPicture,new File(filePath).getAbsolutePath());
    }

    public void pickAddress(String addressValue){
        elementMethods.fillElement(adress, addressValue);
    }

    public void pickState(String stateLoc){
        elementMethods.clickElemForce(selectState);
        elementMethods.fillPressElement(selectState2,stateLoc,Keys.ENTER);
    }

    public void pickCity(String cityLoc){
        elementMethods.clickElemForce(selectCity);
        elementMethods.fillPressElement(selectCity2, cityLoc, Keys.ENTER);
    }

    public void clickSubmit(){
        elementMethods.clickElemForce(submit);
    }

    public void validatePracticeFormTable(PracticeFormObject practiceFormObject){
        elementMethods.validateElementText(labelFields.get(0),"Student Name");
        elementMethods.validateElementText(valuesFields.get(0),practiceFormObject.getFirstNameFieldValue() + " " + practiceFormObject.getLastNameFieldValue());

        elementMethods.validateElementText(labelFields.get(1), "Student Email");
        elementMethods.validateElementText(valuesFields.get(1), practiceFormObject.getEmailFieldValue());

        elementMethods.validateElementText(labelFields.get(2), "Gender");
        elementMethods.validateElementText(valuesFields.get(2), practiceFormObject.getGenderValue());

        elementMethods.validateElementText(labelFields.get(3), "Mobile");
        elementMethods.validateElementText(valuesFields.get(3), practiceFormObject.getMobileNoFieldValue());

        elementMethods.validateElementText(labelFields.get(4), "Date of Birth");
       // Assert.assertEquals(valuesFields.get(4).getText(), practiceFormObject.get );

        elementMethods.validateElementText(labelFields.get(5), "Subjects");
        elementMethods.validateElementText(valuesFields.get(5), practiceFormObject.getUserSubjectsValue());

        elementMethods.validateElementText(labelFields.get(6), "Hobbies");
        for (String hobby : practiceFormObject.getHobbies()) {
            elementMethods.validateElementTextSpecial(valuesFields.get(6), hobby);
        }

        elementMethods.validateElementText(labelFields.get(7), "Picture");
        String[] arrayFile = practiceFormObject.getFilePath().split("/");
        Integer desiredIndex = arrayFile.length -1;
        elementMethods.validateElementText(valuesFields.get(7),arrayFile[desiredIndex]);

        // TEMA: de continuat validarile

        elementMethods.validateElementText(labelFields.get(8), "Address");
        elementMethods.validateElementText(valuesFields.get(8), practiceFormObject.getAdressValue());

        elementMethods.validateElementText(labelFields.get(9), "State and City");
        elementMethods.validateElementText(valuesFields.get(9), practiceFormObject.getStateLoc() + " " + practiceFormObject.getCityLoc());

    }

    public void fillEntireForm(PracticeFormObject practiceFormObject){
        fillFirstName(practiceFormObject.getFirstNameFieldValue());
        fillLastName(practiceFormObject.getLastNameFieldValue());
        fillEmailField(practiceFormObject.getEmailFieldValue());
        fillMobileNoField(practiceFormObject.getMobileNoFieldValue());
        pickBirthDate(practiceFormObject.getDobMonthValue(), practiceFormObject.getYearValue(), practiceFormObject.getDayValue());
        pickGender(practiceFormObject.getGenderValue());
        pickHobbies(practiceFormObject.getHobbies());
        pickSubjects(practiceFormObject.getUserSubjectsValue());
        uploadPicture(practiceFormObject.getFilePath());
        pickAddress(practiceFormObject.getAdressValue());
        pickState(practiceFormObject.getStateLoc());
        pickCity(practiceFormObject.getCityLoc());
        clickSubmit();
    }
}
