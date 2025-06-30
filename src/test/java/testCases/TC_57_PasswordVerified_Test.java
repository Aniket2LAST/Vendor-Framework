package testCases;

import org.testng.annotations.Test;

import pageObjects.Password_Verification_Page;
import testBase.BaseClass;

public class TC_57_PasswordVerified_Test extends BaseClass {
    
	@Test
	public void isPassword() throws InterruptedException {
		Password_Verification_Page np=new Password_Verification_Page(driver);
		np.isPasswordChange();
	}
}
