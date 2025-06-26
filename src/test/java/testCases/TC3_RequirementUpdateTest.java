package testCases;

import org.testng.annotations.Test;

import pageObjects.RequirementUpdatePage;
import testBase.BaseClass;

public class TC3_RequirementUpdateTest extends BaseClass{
    
	@Test
	public void requirement() throws InterruptedException {
		RequirementUpdatePage  rp=new RequirementUpdatePage (driver);
		rp.requirement_Status();
	}
}
