package testCases;

import org.testng.annotations.Test;

import pageObjects.Requirement_NoApplicant_Verified_Page;
import testBase.BaseClass;

public class TC_30_No_Applicant_Test extends BaseClass {

	@Test
	public void isCount() {
		Requirement_NoApplicant_Verified_Page np=new Requirement_NoApplicant_Verified_Page(driver);
		np.no_applicant_count();
	}
}
