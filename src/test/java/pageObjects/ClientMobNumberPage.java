package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ClientMobNumberPage extends BasePage{
	
	public ClientMobNumberPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[@href='/company/clients']")
	WebElement client;
	
	@FindBy(xpath="//button[normalize-space()='Add new client']")
	WebElement addClient;
	
	@FindBy(xpath="//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-contained MuiFormHelperText-filled css-1h5xszz']") 
	WebElement mobileNum10Digit;
    @FindBy(xpath="//input[@name='clientName']")  WebElement name;
    @FindBy(xpath="//div[@class='ql-editor ql-blank']") WebElement nameName;
    @FindBy(xpath="//input[@name='contactPhone']") WebElement contactMobile;
    @FindBy(xpath="//input[@name='contactEmail']") WebElement contactEmail;
    @FindBy(xpath="//input[@placeholder='Address']") WebElement address;
    @FindBy(xpath="//input[@name='website']")  WebElement websiteURL;
    @FindBy(xpath="//button[normalize-space()='Submit']")  WebElement submit;

   public void checkClientMob() throws InterruptedException {
	   client.click();
	   Thread.sleep(4000);
	   addClient.click();
	   Thread.sleep(4000);
	   name.sendKeys("tushar");
	   nameName.sendKeys("fsahahgjvajv");
	   contactMobile.sendKeys("98765427");
	   contactEmail.sendKeys("tushar@gmail.com");
	   address.sendKeys("delhi");
	   websiteURL.sendKeys("www.highSoftware.com");
	   Thread.sleep(4000);
	   
	   
	   submit.click();
	   Thread.sleep(3000);
	   String text=mobileNum10Digit.getText();
	   SoftAssert ap=new SoftAssert();
	   ap.assertEquals(text,"Mobile number must be 10 digits");
   }
}
