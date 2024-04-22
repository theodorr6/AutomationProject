package SharedData;

import loggerUtility.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {

    private String testName;

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTC(testName);
        prepareDriver();
        LoggerUtility.infoTest("Driver opened successfully");

    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if(!result.isSuccess()){
            LoggerUtility.errorTest(result.getThrowable().getMessage());
        }
        clearDriver();
        LoggerUtility.finishedTC(testName);
        LoggerUtility.infoTest("Driver closed successfully");
    }


}
