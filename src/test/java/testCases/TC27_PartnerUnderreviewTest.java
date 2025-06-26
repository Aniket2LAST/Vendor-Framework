package testCases;

import org.testng.annotations.Test;

import pageObjects.PartnerDashboardUnderreview_page;
import testBase.BaseClass;

public class TC27_PartnerUnderreviewTest extends BaseClass {
     
	@Test
	public void isVerified() throws InterruptedException {
		
	PartnerDashboardUnderreview_page pp=new PartnerDashboardUnderreview_page(driver);
	
	pp.isCountDisplay();
	}
}
