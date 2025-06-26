package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.AllureScreenshot;
import org.openqa.selenium.WebDriver;
import testBase.BaseClass;


import com.aventstack.extentreports.Status;
import utilities.ExtentReport;
import utilities.ExtentTestManager;

public class TestListener implements ITestListener {

    public void onStart(ITestContext context) {
        ExtentReport.getInstance();
    }

    public void onTestStart(ITestResult result) {
        ExtentTestManager.setTest(
            ExtentReport.getInstance().createTest(result.getMethod().getMethodName())
        );
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());

        // Capture Allure screenshot
        Object testInstance = result.getInstance();
        WebDriver driver = ((BaseClass) testInstance).getDriver();  // Ensure BaseClass has getDriver()

        AllureScreenshot.captureScreenshot(driver);  // This attaches screenshot to Allure
    }


    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test skipped: " + result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        ExtentReport.getInstance().flush();
    }
}
