package Pages;

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

    public void validatePracticeFormTable(String firstNameFieldValue, String lastNameFieldValue, String emailFieldValue, String genderValue, String mobileNoFieldValue,
                                          String subjectValue,List<String> hobbies, String filePath, String adressValue, String stateLoc, String cityLoc){
        Assert.assertEquals(labelFields.get(0).getText(),"Student Name");
        Assert.assertEquals(valuesFields.get(0).getText(),firstNameFieldValue + " " + lastNameFieldValue);

        Assert.assertEquals(labelFields.get(1).getText(), "Student Email");
        Assert.assertEquals(valuesFields.get(1).getText(), emailFieldValue);

        Assert.assertEquals(labelFields.get(2).getText(), "Gender");
        Assert.assertEquals(valuesFields.get(2).getText(), genderValue);

        Assert.assertEquals(labelFields.get(3).getText(), "Mobile");
        Assert.assertEquals(valuesFields.get(3).getText(), mobileNoFieldValue);

        Assert.assertEquals(labelFields.get(4).getText(), "Date of Birth");
        // Assert.assertEquals(valuesFields.get(4).getText(), dobField );

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
