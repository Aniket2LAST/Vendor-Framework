package vendortestcases;

import org.testng.annotations.Test;

import pageObjects.vendor_requirement_open_position_Page;
import testBase.BaseClass;

public class TC_22_Open_Position_Test extends BaseClass {
    
	@Test
	public void isCountCorrect() throws InterruptedException {
		 vendor_requirement_open_position_Page np=new  vendor_requirement_open_position_Page(driver);
		 np.isVerified();
	}
}
