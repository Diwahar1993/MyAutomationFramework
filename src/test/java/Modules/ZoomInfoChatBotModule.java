package Modules;

import Utils.ExtentReportsManager;
import Webpages.ZoomInfoChatBot.ZoomInfoChatBotMainPage;

/**
 * Author: Diwahar Pandian
 */
public class ZoomInfoChatBotModule {

    // Verify if the ChatBot URL is loaded successfully and its title matches the expected title
    public void VerifyWebPageIsLoadedSuccessFully(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage, String ExpectedTitle) {
        // Step 1: Load the URL of the ChatBot Page
        // Step 2: Get the Title of the Page
        // Step 3: Verify if the title is Insent.ai
        String ActualTitle = zoomInfoChatBotMainPage.getTitle();
        if (ExpectedTitle.equals(ActualTitle)) {
            ExtentReportsManager.logPass("URL is loaded successfully, and the Title is Matched");
        } else {
            ExtentReportsManager.logFail("URL not matched! Expected " + ExpectedTitle + " But Actual is " + ActualTitle);
        }
    }

    // Verify if the policy wording matches the expected wording and accept cookies
    public void VerifyLoadAndAcceptCookies(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage, String ExpectedPolicyWords) {
        // Verify if the Policy wording is matching as Expected
        String actualPolicyWording = zoomInfoChatBotMainPage.readPolicyWording();
        if (actualPolicyWording.equals(ExpectedPolicyWords)) {
            ExtentReportsManager.logPass("Policy Wording is matching as Expected");
        } else {
            ExtentReportsManager.logFail("Policy Wording not matched! Expected " + ExpectedPolicyWords + " But Actual is " + actualPolicyWording);
        }

        zoomInfoChatBotMainPage.acceptPolicy();
    }

    // Verify if the welcome message is displayed as expected
    public void VerifyWelcomeMessage(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage, String expected) {
        try {
            zoomInfoChatBotMainPage.acceptPolicy();
            String actual = zoomInfoChatBotMainPage.getInstantPopUpMessage();
            if (expected.equals(actual)) {
                ExtentReportsManager.logPass("Instant Welcome Pop Up is displayed successfully");
            } else {
                ExtentReportsManager.logFail("Instant pop-up not matched! Expected " + expected + " But Actual is " + actual);
            }
        } catch (Throwable t) {
            t.printStackTrace();
            ExtentReportsManager.logFail("Exception happened" + t.getMessage());
        }
    }

    // Verify if the welcome message can be closed when hovered and clicked
    public void VerifyWelcomeMessageisClosedWhenHoverdAndClicked(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage) {
        zoomInfoChatBotMainPage.acceptPolicy();
        String policyWordings = zoomInfoChatBotMainPage.readPolicyWording();
        if (!policyWordings.equals("")) {
            zoomInfoChatBotMainPage.hoverToCloseIconAndClick();
        }
        // Verify post-closing, only the icon is displayed
        if (zoomInfoChatBotMainPage.isinsentLauncherIconIsDisplayed()) {
            ExtentReportsManager.logPass("Launcher ICON is displayed successfully after closing the chatbot");
        } else {
            ExtentReportsManager.logFail("Launcher ICON not displayed after closing chatbot");
        }
    }

    // Verify if the unread message notification icon is displayed and vanishes after reading
    public void VerifyUnreadMessageNotification(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage) {
        zoomInfoChatBotMainPage.acceptPolicy();
        zoomInfoChatBotMainPage.switchToChatBotFrame();
        zoomInfoChatBotMainPage.hoverToCloseIconAndClick();
        boolean unreadNotificationVisible = zoomInfoChatBotMainPage.isUnreadNotificationDisplayed();

        if (unreadNotificationVisible) {
            ExtentReportsManager.logPass("Unread Notification icon is displayed successfully when the message is not read");
        } else {
            ExtentReportsManager.logFail("Unread Notification icon is not displayed when no message is read");
        }
    }

    // Verify if a valid email input is accepted, and a default message is displayed
    public void verifyIfTheEmailInputIsValid(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage, String email) {
        zoomInfoChatBotMainPage.acceptPolicy();
        zoomInfoChatBotMainPage.switchToChatBotFrame();
        zoomInfoChatBotMainPage.clickOpenChatBotWindow();
        if (zoomInfoChatBotMainPage.checkifEmailInputBoxisVisible()) {
            zoomInfoChatBotMainPage.enterEmail(email);
            zoomInfoChatBotMainPage.submitEmail();
            if (zoomInfoChatBotMainPage.isDefaultHowDoYouKnowDisplayed()) {
                String expected = zoomInfoChatBotMainPage.getHowDoYouKnowText();
                if (expected.equals("How do you know about Zoominfo?")) {
                    ExtentReportsManager.logPass("Valid email is accepted successfully, and how do you know default message is displayed");
                } else {
                    ExtentReportsManager.logFail("Valid Email id is not accepted");
                }
            }
        }
    }

    // Verify if an invalid email input returns an error message
    public void verifyifEmailFieldReturnsErrorwithInvalidEmail(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage, String email, String expectedMessage) {
        zoomInfoChatBotMainPage.acceptPolicy();
        zoomInfoChatBotMainPage.switchToChatBotFrame();
        zoomInfoChatBotMainPage.clickOpenChatBotWindow();
        if (zoomInfoChatBotMainPage.checkifEmailInputBoxisVisible()) {
            zoomInfoChatBotMainPage.enterEmail(email);
            zoomInfoChatBotMainPage.submitEmail();
            String actual = zoomInfoChatBotMainPage.getErrorToasterMessage(expectedMessage);
            if (expectedMessage.equals(actual)) {
                ExtentReportsManager.logPass("Valid error message " + actual + " is thrown");
            } else {
                ExtentReportsManager.logFail("Invalid Error message is Displayed");
            }
        }
    }

    // Verify if an User is able to restart the conversation
    public void verifyIfUserIsAbleToRestarTheConversation(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage) {
        zoomInfoChatBotMainPage.acceptPolicy();
        zoomInfoChatBotMainPage.switchToChatBotFrame();
        zoomInfoChatBotMainPage.clickOpenChatBotWindow();
        zoomInfoChatBotMainPage.clickRestartConversation();
        String actualChatBotText = zoomInfoChatBotMainPage.getLastChatBotMentionText();
        String expected = "@InsentBot";
        if (actualChatBotText.equals(expected)) {
            ExtentReportsManager.logPass("Valid last mention " + actualChatBotText + " is Displayed");
        } else {
            ExtentReportsManager.logFail("Valid last mention is not displayed ! Actual :"+actualChatBotText+" Expected : "+expected);
        }
        //verify if email input box is again asked to user

        if(zoomInfoChatBotMainPage.checkifEmailInputBoxisVisible()){
            ExtentReportsManager.logPass("Email is again asked to user after restart " );
        }else {
            ExtentReportsManager.logFail("Email input is not displayed");
        }

    }

    public void verifyIfUserisAbleToOpenAndCloseTheChat(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage) {
        zoomInfoChatBotMainPage.acceptPolicy();
        zoomInfoChatBotMainPage.switchToChatBotFrame();
        zoomInfoChatBotMainPage.clickOpenChatBotWindow();
        //verify if you are able to view the open chatWindow
        if(zoomInfoChatBotMainPage.conversationListIsDisplayed()){
            ExtentReportsManager.logPass("Chat window is opened successfully " );
        }else{
            ExtentReportsManager.logFail("FAILED | chat window is not displayed");
        }

        //close the chat and see if chat window is not displayed
        zoomInfoChatBotMainPage.CloseIconAndClick();
        if(!zoomInfoChatBotMainPage.conversationListIsDisplayed()){
            ExtentReportsManager.logPass("Chat window is closed successfully " );
        }else{
            ExtentReportsManager.logFail("FAILED | chat window is not closed");
        }


    }

    public void verifyIfUserIsAbleToOpenNewTabAndComeBackToChat(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage) {
        zoomInfoChatBotMainPage.acceptPolicy();
        zoomInfoChatBotMainPage.switchToChatBotFrame();
        zoomInfoChatBotMainPage.clickOpenChatBotWindow();
        //openNew tab "google.com"
        zoomInfoChatBotMainPage.openNewTabAndLoadGoogleAndWaitfor10SecAndReturnBackToChat("https://www.google.com/");
        String titleAfterSwitching = zoomInfoChatBotMainPage.getCurrentWindowTitle();
        if(titleAfterSwitching.equals("Insent.ai")){
            ExtentReportsManager.logPass("Opened google and came back to the chat bot page sucessfully" );
            //again switch to chatbot and open and operate chat
            zoomInfoChatBotMainPage.switchToChatBotFrame();
            zoomInfoChatBotMainPage.clickRestartConversation();
            if (zoomInfoChatBotMainPage.checkifEmailInputBoxisVisible()) {
                zoomInfoChatBotMainPage.enterEmail("success@zoominfo.com");
                ExtentReportsManager.logPass("Opened google and came back to the chat bot and able to successfully interact" );

            }else {
                ExtentReportsManager.logFail("FAILED | opened google and did not come back to original page and Failed chat interaction");
            }


        }else {
            ExtentReportsManager.logFail("FAILED | opened google and did not come back to original page");
        }


    }
}
