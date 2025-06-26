package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class Vendor_Bench_Search_Page extends BasePage {

	public Vendor_Bench_Search_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@href='/vendor/bench']")
	WebElement bench;
	
	@FindBy(xpath="//table//tbody//tr//div//div//div/div[2]")
	WebElement table;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search;
	
	@FindBy(xpath="//div[contains(text(),'Java Developer')]")
	WebElement match;
	
	
	String text1="Java Developer";
	
	public void isBenchVerified() throws InterruptedException {
		bench.click();
		Thread.sleep(8000);
		table.click();
		Thread.sleep(4000);
		search.sendKeys(text1);
		Thread.sleep(4000);
		String text2= match.getText();
		
		SoftAssert sp=new SoftAssert();
		sp.assertEquals(text1, text2);
	}
}
