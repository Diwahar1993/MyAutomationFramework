package Webpages.DemoAutomationWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AmazonPage {

    WebDriver driver;
    private static final String URL="https://www.amazon.in/";

    public AmazonPage(WebDriver driver){
        this.driver=driver;
        driver.get(URL);
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath ="//select[@id='searchDropdownBox']")
    WebElement searchBoxDropDown;

    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    WebElement searchBox;

    @FindBy(xpath="//input[@id='nav-search-submit-button']")
    WebElement SearchButton;

    public void clickSearchBox(){
        Select select = new Select(searchBoxDropDown);
        List<WebElement> searchDropDownOption =select.getOptions();

        for(WebElement option : searchDropDownOption){
           // System.out.println(option.getText());
            if(option.getText().equals("Computers & Accessories")){
               option.click();
                searchBox.sendKeys("Laptop");
                SearchButton.click();

                System.out.println(driver.getTitle());
                Assert.assertEquals(driver.getTitle(),"Amazon.in : Laptop");
                break;

            }
        }

    }



}
