package testCases;

import org.testng.annotations.Test;

import io.qameta.allure.*;
import pageObjects.Requirement_Client_Page;
import testBase.BaseClass;

public class TC9_Requirement_Client_Page extends BaseClass {

    @Epic("Client Management")
    @Feature("Client Search")
    @Story("Search clients from Requirement Page")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups="Smoke", description="Verify client search functionality in Requirement_Client_Page")
    public void client() throws InterruptedException {
        Requirement_Client_Page bg = new Requirement_Client_Page(driver);
        bg.client_search();
    }
}

