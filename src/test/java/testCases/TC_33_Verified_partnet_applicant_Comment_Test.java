package testCases;

import org.testng.annotations.Test;

import pageObjects.Partner_Candidate_Status_Comment_Page;
import testBase.BaseClass;

public class TC_33_Verified_partnet_applicant_Comment_Test extends BaseClass {
    
	@Test
	public void isVerified_Comment() throws InterruptedException {
		Partner_Candidate_Status_Comment_Page np=new Partner_Candidate_Status_Comment_Page(driver);
		np.applicant_Comment();
	}
}
