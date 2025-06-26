package testCases;
import java.io.IOException;

import org.testng.annotations.Test;

import io.qameta.allure.*;
import pageObjects.ProfilePage;
import testBase.BaseClass;

public class TC2_ProfileUpdateTest extends BaseClass {

    @Epic("User Profile")
    @Feature("Profile Update")
    @Story("Update user profile details")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description="Update profile information in user account", groups="Smoke")
    public void updateProfile() throws InterruptedException, IOException {
        ProfilePage pp = new ProfilePage(driver);
        pp.updateProfile();
    }
}
