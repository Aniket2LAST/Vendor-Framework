package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class PartnerDashboardUnderreview_page extends BasePage {
   
	public PartnerDashboardUnderreview_page(WebDriver driver) {
		super(driver);
	}
	
     

	@FindBy(xpath="//h5[@class='MuiTypography-root MuiTypography-h5 !text-indigo-400 css-1faowcc']")
	WebElement Status_count;
	//@FindBy(xpath="//p[normalize-space()='Candidates to review']")
	//WebElement  candidate_review;
	@FindBy(xpath="//table//tbody//tr[2]//td[3]")
	WebElement table;
	
	
	public void  isCountDisplay() throws InterruptedException {
		
		Status_count.getText();
		Thread.sleep(4000);
		Status_count.click();
		Thread.sleep(5000);
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));
		
		for (int i = 1; i <= rows.size(); i++) {
		    // Build XPath dynamically for each row
		    String xpath = "//table//tbody//tr[" + i + "]//td[3]";
		    
		    WebElement Ele=driver.findElement(By.xpath(xpath));
		    String text_table=Ele.getText();
		    SoftAssert sp=new SoftAssert();
		    sp.assertEquals(text_table,"Under Review");    
		    
		    try {
	             sp.assertAll(); // This throws AssertionError if any soft assert fails
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
	
}
