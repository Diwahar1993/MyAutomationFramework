package Tests;

import Utils.ExtentReportsManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite(){
        // to include any actions that needs to be performed before suite
    }

    @AfterSuite
    public void afterSuite(){
        // to include any actions that needs to be performed After suite
        ExtentReportsManager.flushReport();

    }
}
