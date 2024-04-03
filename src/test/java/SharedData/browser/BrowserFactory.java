package SharedData.browser;

import PropertyUtility.PropertyUtility;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    //aplicam design pattern-ul "Factory method" ca sa definim un obiect care sa primeasca o instanta diferita de browser

    public WebDriver getBrowserInstance(){
        PropertyUtility propertyUtility = new PropertyUtility("atfData");
        Map<String, String> browserData = propertyUtility.getAllData();
        String ciCd = System.getProperty("ciCd");
        String browser = System.getProperty("browser");

        if(Boolean.parseBoolean(ciCd)){
            browserData.put("headless","--headless=new");
        } else {
            browser = browserData.get("browser");
        }

        System.out.println("!!!!!!!!!!!!");
        System.out.println(browser);

        // dupa ce am aflat pe ce environment trebuie sa rulez, deschid browserul dorit

        switch (browser){
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser(browserData);
                return chromeService.getWebDriver();
            case "edge":
            EdgeService edgeService = new EdgeService();
            edgeService.openBrowser(browserData);
            return edgeService.getWebDriver();
        }
        return null;
    }
}
