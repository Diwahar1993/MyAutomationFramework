package Tests;

import Utils.ExtentReportsManager;
import Utils.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite(){
//Delete all report and Screenshots
        String folderPath = System.getProperty("user.dir")+"/Report";
        System.out.println("Report folder path is "+folderPath);

        // Create a File object for the specified folder
        File folder = new File(folderPath);

        // to include any actions that needs to be performed before suite
        FileUtils.deleteFolderContents(folder);
    }


}
