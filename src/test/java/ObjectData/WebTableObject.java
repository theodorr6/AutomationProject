package ObjectData;

import java.util.Map;

public class WebTableObject {


    private String firstNameValue;
    private String lastNameValue;
    private String emailFieldValue;
    private String ageFieldValue;
    private String salaryFieldValue;
    private String departmentFieldValue;


    // facem o metoda care sa mapeze datele din fisierul de resursa cu reprezentarea acestui obiect

    public WebTableObject (Map<String, String> testData){
    prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testData) {

        for (String key : testData.keySet()) {
            switch (key) {
                case "firstNameValue":
                    setFirstNameValue(testData.get(key));
                    break;
                case "lastNameValue":
                    setLastNameValue(testData.get(key));
                    break;
                case "emailFieldValue":
                    setEmailFieldValue(testData.get(key));
                    break;
                case "ageFieldValue":
                    setAgeFieldValue(testData.get(key));
                    break;
                case "salaryFieldValue":
                    setSalaryFieldValue(testData.get(key));
                    break;
                case "departmentFieldValue":
                    setDepartmentFieldValue(testData.get(key));
                    break;

            }
        }
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getEmailFieldValue() {
        return emailFieldValue;
    }

    public void setEmailFieldValue(String emailFieldValue) {
        this.emailFieldValue = emailFieldValue;
    }

    public String getAgeFieldValue() {
        return ageFieldValue;
    }

    public void setAgeFieldValue(String ageFieldValue) {
        this.ageFieldValue = ageFieldValue;
    }

    public String getSalaryFieldValue() {
        return salaryFieldValue;
    }

    public void setSalaryFieldValue(String salaryFieldValue) {
        this.salaryFieldValue = salaryFieldValue;
    }

    public String getDepartmentFieldValue() {
        return departmentFieldValue;
    }

    public void setDepartmentFieldValue(String departmentFieldValue) {
        this.departmentFieldValue = departmentFieldValue;
    }


}
