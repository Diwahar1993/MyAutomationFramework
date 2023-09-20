package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

public class ExtentReportsManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    static String baseDir = System.getProperty("user.dir");
    static String ReportPath = baseDir + "/src/test/resources/Report/extent-report.html";

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ReportPath);
            htmlReporter.config().setDocumentTitle("AUTOMATION TEST REPORT");
            htmlReporter.config().setReportName("ZOOMINFO CHATBOT");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static synchronized void startTest(String testName) {
        ExtentTest extentTest = getInstance().createTest(testName);
        test.set(extentTest);
    }

    public static synchronized void logInfo(String message) {
        test.get().info(message);
    }

    public static synchronized void logPass(String message) {
        test.get().pass(message);
    }

    public static synchronized void logFail(String message) {
        test.get().fail(message);
    }

    public static synchronized void logScreenshot(String screenshotPath, String description) throws IOException {
        test.get().addScreenCaptureFromPath(screenshotPath, description);
    }

    public static synchronized void logInfoWithMarkup(String message) {
        test.get().log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.BLUE));
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
