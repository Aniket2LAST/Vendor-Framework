package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class Password_Verification_Page extends BasePage {
	
	public Password_Verification_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//p[@class='text-base truncate text-ellipsis']") 
	WebElement profile_Icon;
	
	@FindBy(xpath="//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-contained MuiFormHelperText-filled css-1h5xszz']") 
	WebElement useDifferentPassword;
	
    @FindBy(xpath="//input[@name='newPassword']") 
    WebElement newPassword;
    
    @FindBy(xpath="//input[@name='oldPassword'])[1]")
    WebElement oldPassword;
    
    @FindBy(xpath="//button[normalize-space()='Change Password']")
    WebElement btn;
    
    
    public void isPasswordChange() throws InterruptedException {
    	profile_Icon.click();
    	oldPassword.sendKeys("test@12345");
    	Thread.sleep(6000);
    	newPassword.sendKeys("test@12345");
    	Thread.sleep(6000);
    	btn.click();
    	Thread.sleep(6000);
    	String text1=useDifferentPassword.getText();
    	SoftAssert sp=new SoftAssert();
    	if(text1.equalsIgnoreCase("Use Different Password")) {
    	sp.assertTrue(true);
    	}
    	sp.assertAll();
    	
    }

}

