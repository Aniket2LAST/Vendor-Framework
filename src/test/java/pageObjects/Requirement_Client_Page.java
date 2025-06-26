package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class Requirement_Client_Page extends BasePage {

	public Requirement_Client_Page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Requirements']")
	WebElement requirement;
      
	@FindBy(xpath="//button[normalize-space()='Client']")
	WebElement  client;
	
    
	@FindBy(xpath="(//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary !text-base css-1x7rkuw'][normalize-space()='FLower'])[1]")
	WebElement  client_choose;
	
	
	@FindBy(xpath="//table//tbody//tr[1]//th[1]//div[2]//div[1]")
	WebElement table;
	
	
	public void client_search() throws InterruptedException {
		Thread.sleep(3000);
		requirement.click();
		Thread.sleep(3000);
		client.click();
		Thread.sleep(3000);
		client_choose.click();
		Thread.sleep(3000);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

		// Iterate over each row
		for (int i = 1; i <= rows.size(); i++) {
		    // Build XPath dynamically for each row
		    String xpath = "//table//tbody//tr[" + i + "]//th[1]//div[2]//div[1]";
		    
		    
		        WebElement element = driver.findElement(By.xpath(xpath));
		        String text=element.getText();
		        String text1=client_choose.getText();
		        System.out.println("Row " + i + ": " + text);
		        Reporter.log("text visible on  choose ="+text1+" text visible on table = "+text);
		        SoftAssert sp=new SoftAssert();
		        sp.assertEquals(text,text1);
		        sp.assertAll();
		        
		    
		}
	}
	
}
