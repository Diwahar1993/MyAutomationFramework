package Modules;

import Utils.ExtentReportsManager;
import Webpages.ZoomInfoChatBot.ZoomInfoChatBotMainPage;
import org.testng.Assert;

public class ZoomInfoChatBotModule {


    public void VerifyWebPageIsLoadedSuccessFully(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage,String ExpectedTitle) {

        ExtentReportsManager.logInfo("STEPS :\n" +
                "    1) Load the URL of the ChatBot Page\n" +
                "    2) Get the Title of the Page\n" +
                "    3) Verify if the title is Insent.ai");
        String ActualTitle = zoomInfoChatBotMainPage.getTitle();
       if(ExpectedTitle.equals(ActualTitle)){
           ExtentReportsManager.logPass(" URL is loaded successfully and the Title is Matched");
       }else {
           ExtentReportsManager.logFail("URL not matched ! Expected "+ExpectedTitle+" But Actual is "+ActualTitle);
       }


    }

    public void VerifyLoadAndAcceptCookies(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage,String ExpectedPolicyWords) {
        ExtentReportsManager.logInfo("Verify if the Policy wording is matching as Expected");
        String actualPolicyWording = zoomInfoChatBotMainPage.readPolicyWording();
        if(actualPolicyWording.equals(ExpectedPolicyWords)){
            ExtentReportsManager.logPass(" Policy Wording is matching as Expected");
        }else {
            ExtentReportsManager.logFail("Policy Wording not matched ! Expected "+ExpectedPolicyWords+" But Actual is "+actualPolicyWording);
        }

        zoomInfoChatBotMainPage.acceptPolicy();

    }

    public void VerifyWelcomeMessage(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage, String expected) {
       try{
           zoomInfoChatBotMainPage.acceptPolicy();
           String actual = zoomInfoChatBotMainPage.getInstantPopUpMessage();
           if(expected.equals(actual)){
               ExtentReportsManager.logPass(" Instant Welcome Pop Up is displayed successfully");
           }else {
               ExtentReportsManager.logFail("Instant popUp not matched ! Expected "+expected+" But Actual is "+actual);
           }
       }catch(Throwable t){
           t.printStackTrace();
           ExtentReportsManager.logFail("Exception happened"+t.getMessage());

       }
    }

    public void VerifyWelcomeMessageisClosedWhenHoverdAndClicked(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage) {
        zoomInfoChatBotMainPage.acceptPolicy();
        String policyWordings = zoomInfoChatBotMainPage.readPolicyWording();
        if(!policyWordings.equals("")){
            zoomInfoChatBotMainPage.hoverToCloseIconAndClick();
        }
        // verify post closing, only icon is displayed
        if(zoomInfoChatBotMainPage.isinsentLauncherIconIsDisplayed()){
            ExtentReportsManager.logPass(" Launcher ICON is displayed successfully after closing the chatbot");
        }else{
            ExtentReportsManager.logFail("Launcher ICON not displayed after closing chatbot");
        }
    }

    public void VerifyUnreadMessageNotification(ZoomInfoChatBotMainPage zoomInfoChatBotMainPage) {
        zoomInfoChatBotMainPage.acceptPolicy();
        zoomInfoChatBotMainPage.switchToChatBotFrame();
        zoomInfoChatBotMainPage.hoverToCloseIconAndClick();
       // zoomInfoChatBotMainPage.waitforSometime();
        boolean unreadNotificationVisible = zoomInfoChatBotMainPage.isUnreadNotificationDisplayed();

        if(unreadNotificationVisible){
            ExtentReportsManager.logPass(" unread Notification icon is displayed successfully when message is not read");
        }else {
            ExtentReportsManager.logFail("unread Notification icon is not displayed, when no message is read");

        }

        // click and read message and check if visiblity is false
    }
}
