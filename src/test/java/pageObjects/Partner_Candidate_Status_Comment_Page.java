package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class Partner_Candidate_Status_Comment_Page extends BasePage {
   
	public Partner_Candidate_Status_Comment_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='Applicants']")
    WebElement applicants;
	
	@FindBy(xpath="//table//tbody//tr[2]//td[3]")
	WebElement table;
	
	@FindBy(xpath="//input[@value='Under Review']") 
    WebElement status;
	
	@FindBy(xpath="//textarea[@name='Comments']")
	WebElement comments;
	
	@FindBy(xpath="//button[normalize-space()='Update']")
	WebElement update;
	
	@FindBy(xpath="//p[text()='you are selelcted']")
	WebElement comment_Text;
	
	
	public void applicant_Comment() throws InterruptedException {
		String s1="you are selelcted";
		applicants.click();
		table.click();
		status.click();
		comments.sendKeys(s1);
		update.click();
		Thread.sleep(5000);
		table.click();
		String text1=comment_Text.getText();
		
		SoftAssert sp=new SoftAssert();
		sp.assertEquals(s1,text1);
		
		sp.assertAll();
	}
	
}
