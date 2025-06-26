package testCases;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.ClientMobNumberPage;

public class TC1_ClientMobVerifiedTest extends BaseClass {

	
	@Test(groups="Sanity")
	public void check_Mob() throws InterruptedException {
		
		 //HomePage hp = new HomePage(driver); // driver is inherited from BaseClass
	     //logger.info("************Starting Login the page*************");
	     //hp.login(); 
		
		 logger.info("******Start*************");
		 ClientMobNumberPage bp=new  ClientMobNumberPage(driver);
		 bp.checkClientMob();
		 
		 logger.info("********End test case tc1");
	}
}
