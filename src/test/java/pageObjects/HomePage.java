package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public Properties p;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email_ele;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password_ele;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;

	 
	public void login(String email,String password) {
		

		
		email_ele.sendKeys(email);
		password_ele.sendKeys(password);
		submit.click();
		
		
	}
	 
}
