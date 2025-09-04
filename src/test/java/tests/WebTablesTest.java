package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WebTablesPage;

public class WebTablesTest extends BaseTest {

    WebTablesPage webTables;

    @BeforeMethod
    public void initPage() {
        // Initialize page object after driver is ready
        webTables = new WebTablesPage(driver);

        // Navigate to the webtables page
        driver.get("https://demoqa.com/webtables");
    }

    @Test
    public void testWebTablesAddDeleteExtract() {
        // Add a new record
        webTables.clickAdd();
        webTables.addRecord("Saran", "S", "saran@example.com", "22", "50000", "QA");

        // Print all table data
        webTables.printAllTableData();

        // Delete first record
        webTables.deleteFirstRecord();

        // Print updated table data
        webTables.printAllTableData();
    }
}
