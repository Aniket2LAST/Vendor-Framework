package vendortestcases;

import org.testng.annotations.Test;

import pageObjects.Vendor_Bench_Search_Page;
import testBase.BaseClass;

public class TC_10_Matching_bench_Test extends BaseClass {
     
	@Test
	public void isMatching() throws InterruptedException {
		 Vendor_Bench_Search_Page np=new  Vendor_Bench_Search_Page(driver);
		 np.isBenchVerified();
	}
}
