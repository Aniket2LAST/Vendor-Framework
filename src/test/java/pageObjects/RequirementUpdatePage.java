package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class RequirementUpdatePage extends BasePage {
	
	public RequirementUpdatePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='Requirements']")
	WebElement requirement;
    
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/p[1]")
	WebElement status;
	
	@FindBy(xpath="//input[@value='OnHold']")
	WebElement onhold;
	
	@FindBy(xpath="//p[text()='Status updated successfully']")
	WebElement update;
	
	@FindBy(xpath="//button[normalize-space()='Update']")
	WebElement btn;
	

	public void requirement_Status() throws InterruptedException {
		requirement.click();
		status.click();
		onhold.click();
		Thread.sleep(3000);
		btn.click();
		Thread.sleep(3000);
		
		
	    String actualText = update.getText().trim();

	    System.out.println("Update message text: " + actualText);
	    Reporter.log("Update message: " + actualText);

	    // Validate update message
	    SoftAssert sp = new SoftAssert();
	    sp.assertEquals(actualText, "Status updated successfully", "Update message mismatch");
	    sp.assertAll();
		
	}
}
