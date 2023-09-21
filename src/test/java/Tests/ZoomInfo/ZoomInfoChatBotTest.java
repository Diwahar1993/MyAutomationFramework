package Tests.ZoomInfo;

import DataProviders.DataProviderClass;
import Modules.ZoomInfoChatBotModule;
import POJO.EmailInputRoot;
import Tests.BaseTest;
import Utils.ExtentReportsManager;
import Utils.JsonUtils;
import Webpages.ZoomInfoChatBot.ZoomInfoChatBotMainPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * Author: Diwahar Pandian
 */
public class ZoomInfoChatBotTest extends BaseTest {
    WebDriver driver;
    ZoomInfoChatBotModule zoomInfoChatBotModule = new ZoomInfoChatBotModule();

    @BeforeTest
    public void setup() {
        // Set up the WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void intitializeDriver() {
        // Initialize the driver and clear cookies before each test method
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

    // Helper method to log test failures
    private void logTestFailure(Throwable t) {
        t.printStackTrace();
        ExtentReportsManager.logFail("Exception happened: " + t.getMessage());
    }

    @Test(enabled = true, priority = 1)
    public void validateMainPage() {
        try {
            // Test 1: Verify if the ChatBotURL is Loaded Successfully
            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify if the ChatBotURL is Loaded Successfully");
            String ExpectedTitle = "Insent.ai";
            zoomInfoChatBotModule.VerifyWebPageIsLoadedSuccessFully(zoomInfoChatBotMainPage, ExpectedTitle);
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @Test(enabled = true, priority = 2)
    public void VerifyReadandAcceptCookies() {
        try {
            // Test 2: Verify if Cookies are loaded and can be accepted
            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify if the Cookies are loaded on the first start and verify if they are closed after accepting");
            String ExpectedPolicyWords = "Insent stores cookies on your computer to improve your website experience and provide more personalized services, both on this website, our chat and through other media. To find out more about the cookies we use, see our Privacy Policy.";
            zoomInfoChatBotModule.VerifyLoadAndAcceptCookies(zoomInfoChatBotMainPage, ExpectedPolicyWords);
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @Test(enabled = true, priority = 3)
    public void VerifyWelcomeMessage() {
        try {
            // Test 3: Verify if Welcome Message is displayed appropriately
            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify if WELCOME MESSAGE is displayed appropriately in the chatBot");
            String expected = "Hi there, welcome";
            zoomInfoChatBotModule.VerifyWelcomeMessage(zoomInfoChatBotMainPage, expected);
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @Test(enabled = true, priority = 4)
    public void VerifyWelcomeMessageCloseIcon() {
        try {
            // Test 4: Verify if Welcome Message can be closed when close icon is hovered and clicked
            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify if WELCOME MESSAGE is closed when close icon is hovered and clicked");
            zoomInfoChatBotModule.VerifyWelcomeMessageisClosedWhenHoverdAndClicked(zoomInfoChatBotMainPage);
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @Test(enabled = true, priority = 5)
    public void VerifyUnReadMessageNotification() {
        try {
            // Test 5: Verify if Unread message notification icon is displayed and vanishes after reading
            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify if Unread message notification icon is displayed in the chatbot icon and post reading it vanishes");
            zoomInfoChatBotModule.VerifyUnreadMessageNotification(zoomInfoChatBotMainPage);
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @Test(enabled = true, priority = 6, dataProvider = "chatBotTestDataSet", dataProviderClass = DataProviderClass.class)
    public void VerifyifUserIsAbleToEnterValidEmailId(Object data) {
        try {
            // Test 6: Verify if User Is Able To Enter a Valid Email ID or get an error with an invalid one
            String dataObject = JsonUtils.objectToJSONString(data);
            ObjectMapper objectMapper = new ObjectMapper();
            EmailInputRoot emailInputRoot = objectMapper.readValue(dataObject, EmailInputRoot.class);

            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify " + emailInputRoot.getScenario());
            if (emailInputRoot.getUseCase().equals("valid")) {
                zoomInfoChatBotModule.verifyIfTheEmailInputIsValid(zoomInfoChatBotMainPage, emailInputRoot.getEmail());
            } else if (emailInputRoot.getUseCase().equals("invalid")) {
                zoomInfoChatBotModule.verifyifEmailFieldReturnsErrorwithInvalidEmail(zoomInfoChatBotMainPage, emailInputRoot.getEmail(), emailInputRoot.getMessage());
            }
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @Test(enabled = true, priority = 7)
    public void VerifyifUserIsAbleToRestartTheConversation() {
        try {
            // Test 7: Verify if User Is Able To Restart The Conversation
            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify if user is able to restart the conversation");
            ExtentReportsManager.logInfoWithMarkup("1) Click open chat \n 2) Click on Restart \n 3) Verify if @mention incent bot is displayed \n 4) Verify if email input field is displayed ");
            zoomInfoChatBotModule.verifyIfUserIsAbleToRestarTheConversation(zoomInfoChatBotMainPage);
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @Test(enabled = true, priority = 8)
    public void VerifyifUserIsAbleToOpenAndCloseThenConversation() {
        try {
            // Test 8: Verify if User Is Able To Open and Close The Conversation
            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify if user is able to Open and Close the conversation");
            ExtentReportsManager.logInfoWithMarkup("1) Click open chat \n 2) Click on chat to Open \n 3) Verify chat window is displayed \n 4) close the chat \n Verify if chat is closed correctly ");
            zoomInfoChatBotModule.verifyIfUserisAbleToOpenAndCloseTheChat(zoomInfoChatBotMainPage);
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @Test(enabled = true, priority = 9)
    public void VerifyifUserIsAbleToOpenNewTabAndComeBackToChat() {
        try {
            // Test 9: Verify if User Is Able To Open a New Tab and Come Back To Chat
            ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
            ExtentReportsManager.startTest("Verify if user is able to Open a new tab with google.com ,stay there for 10 seconds, come back to chat\n" +
                    "page and enter the data in the bot");
            ExtentReportsManager.logInfoWithMarkup("Open a new tab with google.com ,stay there for 10 seconds, come back to chat\n" +
                    "page and enter the data in the bot.");
            zoomInfoChatBotModule.verifyIfUserIsAbleToOpenNewTabAndComeBackToChat(zoomInfoChatBotMainPage);
        } catch (Throwable t) {
            logTestFailure(t);
        }
    }

    @AfterMethod
    public void closeDriver() {
        // Close the driver and delete cookies after each test method
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @AfterTest
    public void teardown() {
        // any tear down method to be performed after executing test shall be included here
    }

    @AfterSuite
    public void afterSuite() {
        // to include any actions that need to be performed After suite
        ExtentReportsManager.flushReport();
        while (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
