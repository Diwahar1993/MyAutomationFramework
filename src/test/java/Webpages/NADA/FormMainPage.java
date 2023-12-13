package Webpages.NADA;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FormMainPage {
    private WebDriver driver;
    public FormMainPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get("https://tst-nca-tap-web.tekion.xyz/public/nada-2024");
        System.out.println(driver.findElement(By.xpath("//div[@id='app']")).isDisplayed());
        driver.findElement(By.xpath("//div[@id='app']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='app']")).isDisplayed());


    }

    // element identification
    @FindBy(xpath = "//div[@id='app']//input[contains(@class,'LeadForm') and @aria-label='company details' ]")
    WebElement Company;
    @FindBy(id = "job")
    WebElement job;
    @FindBy(id = "fname")
    WebElement firstName;
    @FindBy(id = "lname")
    WebElement lastName;
    @FindBy(id="email")
    WebElement email;
    @FindBy(id="mobilenumber")
    WebElement mobilenumber;


@FindBy(id = "meetup-btn")
WebElement submit;


public void setCompany(String name){
    WebElement suggestion = driver.findElement(By.xpath("//div[contains(@class,'pac-container')]"));
    System.out.println("is PAC container visible ? "+suggestion.isDisplayed());
    Company.sendKeys(name);
    Company.click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    System.out.println("is PAC container visible ? "+suggestion.isDisplayed());
   List<WebElement> suggestiveCountry = driver.findElements(By.xpath("//div[contains(@class,'pac-container')]//div[@class='pac-item']/span[last()]"));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(suggestion));

    suggestion.click();
    System.out.println("suggestiveCountry size -->"+suggestiveCountry.size());

    int attempts = 0;
    while (attempts < 6) {

        try {
            for(WebElement suggestionElement : suggestiveCountry){
                System.out.println(suggestionElement.isDisplayed());
                System.out.println("suggestion element "+suggestionElement.getText());

            }
            break;
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
        attempts++;
    }

}
public void setJob(String jobName){


    job.sendKeys(jobName);

}
    public void setEmail(String emailName){
        email.sendKeys(emailName);
    }
    public void SetFirstAndLastName(String firstName, String lastName){
    this.firstName.sendKeys(firstName);
    this.lastName.sendKeys(lastName);
    }

    public void setMobilenumber(String mobilenumber){
    this.mobilenumber.sendKeys(mobilenumber);
    }
    public void setInterestButton(String selection){
        List<WebElement> interestButton =driver.findElements(By.xpath(" //div[contains(@class,'LeadForm_interestBtnContainer')]/button"));

        for(WebElement Button :interestButton ){
        System.out.println("button displayed is "+Button.getText());
        if(Button.getText().equals(selection)){
            Button.click();
        }
    }
    }
    public void hitSubmit() throws IOException {
    submit.click();
    String baseDir = System.getProperty("user.dir");
    File Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File file = new File(baseDir+"/screenshot.png");
        FileUtils.copyFile(Screenshot,file);

    }
}

