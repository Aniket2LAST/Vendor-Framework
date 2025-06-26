package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class vendor_requirement_open_position_Page extends BasePage {

    public vendor_requirement_open_position_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[contains(@class, 'MuiTypography-h5')]")
    WebElement total_position;

    @FindBy(xpath = "(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-q7mezt'])[5]")
    WebElement next_page_Icon;

    public void isVerified() throws InterruptedException {
        SoftAssert sp = new SoftAssert();
        int dashPosition = 0;
        int count = 0;

        try {
            // Wait for the dashboard count to be visible
            Thread.sleep(8000);  // Replace with WebDriverWait in production
            String dashCountText = total_position.getText().trim();

            // Parse the dashboard position count
            dashPosition = Integer.parseInt(dashCountText);
            System.out.println("Dashboard Open Position Count: " + dashPosition);

            // Click to navigate (if needed)
            total_position.click();
            Thread.sleep(5000);

            // Start paginated table extraction
            boolean morePages = true;
            while (morePages) {
                Thread.sleep(3000); // Let table load

                List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

                for (int i = 1; i <= rows.size(); i++) {
                    String cellXpath = "//table//tbody//tr[" + i + "]//td[3]";
                    WebElement cell = driver.findElement(By.xpath(cellXpath));
                    String cellText = cell.getText().trim();

                    if (cellText.contains("(")) {
                        int index = cellText.indexOf('(');
                        String numberPart = cellText.substring(0, index).trim();
                        try {
                            int num = Integer.parseInt(numberPart);
                            count += num;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format in row " + i + ": " + numberPart);
                        }
                    }
                }

                // Check if next page icon is enabled
                List<WebElement> nextButtons = driver.findElements(
                        By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-q7mezt'])[5]/ancestor::button[not(@disabled)]"));

                if (!nextButtons.isEmpty()) {
                    nextButtons.get(0).click();
                    Thread.sleep(3000); // Allow time for next page to load
                } else {
                    morePages = false;
                }
            }

        } catch (Exception e) {
            System.out.println("Exception during verification: " + e.getMessage());
            e.printStackTrace();
        }

        // Final assertions and output
        try {
            System.out.println("End of Program");
            System.out.println("Dashboard Open Position Count: " + dashPosition);
            System.out.println("Table Total Count: " + count);
            sp.assertEquals(count, dashPosition, "Mismatch between dashboard and table count.");
            sp.assertAll();
        } catch (Exception finalEx) {
            System.out.println("Assertion or logging error: " + finalEx.getMessage());
            finalEx.printStackTrace();
        }
    }
}
