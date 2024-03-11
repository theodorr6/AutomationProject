package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
