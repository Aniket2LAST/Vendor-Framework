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

public class Requirement_NoApplicant_Verified_Page extends BasePage{
   int count=0;
	public Requirement_NoApplicant_Verified_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h5[@class='MuiTypography-root MuiTypography-h5 !text-red-600 css-1faowcc']")
    WebElement candidateCount;
	
	@FindBy(xpath="//p[normalize-space()='No Applicants']")
    WebElement noApplicant;
	
	@FindBy(xpath="//table//tbody//tr[2]//td[4]")
	WebElement table;
	
	SoftAssert sp=new SoftAssert();
	public void no_applicant_count() {
		
		String noApp=candidateCount.getText();
		noApplicant.click();
	    
		List<WebElement> rows=driver.findElements(By.xpath("//table//tbody//tr"));
		
		for(int i=1;i<=rows.size();i++) {
			
			 String xpath = "//table//tbody//tr[" + i + "]//td[4]";
			    
			    WebElement Ele=driver.findElement(By.xpath(xpath));
			    String text_table=Ele.getText();
			    
			    
			    if(text_table=="-") {
			    	count++;
			    }
			   
		}
		String str = Integer.toString(count);
		sp.assertEquals(str,noApp);
		try {
			sp.assertAll();
		    
		}
		catch (AssertionError e) {
            // Screenshot on failure
       	 System.out.println("Assertion failed — entering screenshot logic.");
            try {
                TakesScreenshot tks = (TakesScreenshot) driver;
                File src = tks.getScreenshotAs(OutputType.FILE);
                File dest = new File("SeleniumFramework//screenshots/NoApplicantCount.png");
                FileUtils.copyFile(src, dest);
                System.out.println("Assertion failed. Screenshot taken.");
            } catch (IOException io) {
                System.out.println(" Failed to capture screenshot: " + io.getMessage());
            }

            // Optional: Re-throw to mark the test as failed
            throw e;
        }
		
	    
	    }
}
