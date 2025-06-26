package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC0_loginTest extends BaseClass {
    
	
	@Test(groups = "Sanity")
	public void login_verify() throws InterruptedException {

		
		/*
		 * HomePage hp = new HomePage(driver); // driver is inherited from BaseClass
		 * logger.info("************Starting Login the page*************"); //
		 * hp.login(email,password);
		 */
		 

		logger.info("***Login Ends**");
		Thread.sleep(1000);

	}
	
	 
}
	

