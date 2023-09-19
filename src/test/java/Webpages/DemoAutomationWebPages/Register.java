package Webpages.DemoAutomationWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;
import java.util.List;

public class Register {

    WebDriver driver;
    private static final String URL="https://demo.automationtesting.in/Register.html";

    public Register(WebDriver driver){
       this.driver=driver;
       driver.get(URL);
        PageFactory.initElements(driver,this);

    }

    // Xpath identification
    @FindBy(xpath = "//form[@id='basicBootstrapForm']//input[ normalize-space(@ng-model)='FirstName' ]")
    WebElement firstName;

    @FindBy(xpath = "//form[@id='basicBootstrapForm']//input[ normalize-space(@ng-model)='LastName' ]")
    WebElement lastName;

    @FindBy(xpath = "//form[@id='basicBootstrapForm']//input[ normalize-space(@ng-model)='EmailAdress' ]")
    WebElement emailAdress;

    @FindBy(xpath ="//form[@id='basicBootstrapForm']//input[ normalize-space(@ng-model)='Phone' ]")
    WebElement phone;

    @FindBy(xpath="//form[@id='basicBootstrapForm']//input[ normalize-space(@ng-model)='Password' ]")
    WebElement Password;

    @FindBy(xpath="//form[@id='basicBootstrapForm']//input[ normalize-space(@ng-model)='CPassword' ]")
    WebElement confirmPassword;

    @FindBy(xpath ="//select[@id='Skills']")
    WebElement chooseskills;









    // actions
public void enterFirstName(String name){
    firstName.clear();
    firstName.sendKeys(name);
}
    public void enterLastName(String name){
        lastName.clear();
        lastName.sendKeys(name);
    }
    public void phone(String phoneNo){
        phone.clear();
        phone.sendKeys(phoneNo);
    }
    public void enterPassword(String name){
        Password.clear();
        Password.sendKeys(name);
    }
    public void enterConfirmPassword(String name){
        confirmPassword.clear();
        confirmPassword.sendKeys(name);
    }


    public void enterEmail(String mail) {
        emailAdress.clear();
        emailAdress.sendKeys(mail);
    }
    public void chooseSkill(){
        Select select = new Select(chooseskills);

        List<WebElement> options= select.getOptions();
        for (WebElement option : options){
            System.out.println(option.getText());
        }
        select.selectByValue("Corel Word Perfect");


    }
}
