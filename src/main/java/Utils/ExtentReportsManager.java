package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

public class ExtentReportsManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    static String baseDir = System.getProperty("user.dir");
    static String ReportPath = baseDir + "/Report/screenshot-report.html";

    // File destinationFile = new File(System.getProperty("user.dir")+"/Report/image_" + System.currentTimeMillis()+ ".png");

    /**
     * Get or create an instance of the ExtentReports class for managing the report.
     */
    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
           /* ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ReportPath);
            htmlReporter.config().setDocumentTitle("AUTOMATION TEST REPORT");
            htmlReporter.config().setReportName("ZOOMINFO CHATBOT");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent.attachReporter(htmlReporter);*/

            //ExtentReports extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(ReportPath);
            extent.attachReporter(spark);

        }
        return extent;
    }

    /**
     * Start a new test.
     */
    public static synchronized void startTest(String testName) {
        ExtentTest extentTest = getInstance().createTest(testName);
        test.set(extentTest);
    }

    /**
     * Log an informational message in the report.
     */
    public static synchronized void logInfo(String message) {
        test.get().info(message);
    }

    /**
     * Log a pass status and message in the report.
     */
    public static synchronized void logPass(String message) {
        test.get().pass(message);
    }

    /**
     * Log a fail status and message in the report.
     */
    public static synchronized void logFail(String message) {
        test.get().fail(message);
    }

    /**
     * Log a screenshot with a description in the report.
     */
    public static synchronized void logScreenshot(String screenshotPath, String description) throws IOException {
        System.out.println("screenshot path for logging : "+screenshotPath);
        test.get().addScreenCaptureFromPath(screenshotPath,description);

    }

    /**
     * Log an informational message with markup (e.g., color) in the report.
     */
    public static synchronized void logInfoWithMarkup(String message) {
        test.get().log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.BLUE));
    }
    public static synchronized  void logScreenshotMedia(String path){
        test.get().log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }
    public static synchronized  void logScreenshotMedia(String path,String description){
        test.get().log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(path,description).build());
    }


    /**
     * Flush and close the report.
     */
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
