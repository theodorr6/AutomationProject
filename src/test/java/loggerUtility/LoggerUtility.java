package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    // in aceasta clasa configuram metode pentru a loga informatii
    // ne trebuie o metoda care sa reprezinte inceputul unui test, finalul unui test, info, error

    private static Logger logger = LogManager.getLogger();

    public static void startTC(String testCase){
        logger.info("****** EXECUTION STARTED: " + testCase + "******");
    }

    public static void finishedTC(String testCase){
        logger.info("****** EXECUTION FINISHED: " + testCase + "******");
    }

    public static void infoTest(String message){
        logger.info(message);
    }

    public static void errorTest(String message){
        logger.info(message);
    }
}
