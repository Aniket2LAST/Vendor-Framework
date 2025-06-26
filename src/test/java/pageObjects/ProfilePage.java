package pageObjects;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class ProfilePage extends BasePage {
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//p[@class='text-base truncate text-ellipsis']")
	WebElement profileIcon;
	

    @FindBy(xpath="//input[@name='firstName']")  WebElement firstName;
    @FindBy(xpath="//input[@name='lastName']")  WebElement lastName;
    @FindBy(xpath="//input[@name='phone']") WebElement phone;
    @FindBy(xpath="//button[normalize-space()='Submit']")  WebElement submit;
    
    public void updateProfile() throws InterruptedException, IOException
    {
    	profileIcon.click();
    	lastName.sendKeys("king");
    	
    	
    	phone.sendKeys(Keys.CONTROL + "a"); 
    	phone .sendKeys(Keys.DELETE);
    	phone.sendKeys("9867543423");
    	Thread.sleep(5000);
    	submit.click();
    	Thread.sleep(5000);
    	String text=profileIcon.getText();
    	
    	 SoftAssert np=new SoftAssert();
    	 np.assertEquals(text, "Aniket kush");
    	 try {
             np.assertAll(); // This throws AssertionError if any soft assert fails
         } catch (AssertionError e) {
             // Screenshot on failure
        	 System.out.println("Assertion failed — entering screenshot logic.");
             try {
                 TakesScreenshot tks = (TakesScreenshot) driver;
                 File src = tks.getScreenshotAs(OutputType.FILE);
                 File dest = new File("SeleniumFramework//screenshots/profilepage.png");
                 FileUtils.copyFile(src, dest);
                 System.out.println("❌ Assertion failed. Screenshot taken.");
             } catch (IOException io) {
                 System.out.println("⚠️ Failed to capture screenshot: " + io.getMessage());
             }

             // Optional: Re-throw to mark the test as failed
             throw e;
         }
    	}
    }

