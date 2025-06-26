package vendortestcases;
 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTestCase {
    
	WebDriver driver;
	@Test
	void open() {
		driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://fl-01-ymen-shared-ui-cin-test.azurewebsites.net/");
	}
	
	
	@Test(priority=1)
	void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("aniket@fleekitsolutions.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(700);
		
	}
	
	@Test(priority=2)
	void close() {
		driver.close();
	}
}
