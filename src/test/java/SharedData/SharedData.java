package SharedData;

import SharedData.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    private WebDriver webDriver;


    public void prepareDriver(){
        webDriver = new BrowserFactory().getBrowserInstance();
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }


    public void clearDriver(){
        webDriver.quit();
    }


}
