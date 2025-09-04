package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DatePickerPage;

public class DatePickerTest extends BaseTest {

    @Test
    public void pickSpecificDate() {
        driver.get("https://demoqa.com/date-picker");
        DatePickerPage datePickerPage = new DatePickerPage(driver);

        // Select 4th August 2025
        datePickerPage.selectDate(4, "August", "2025");

        // Verify the date
        String selectedDate = datePickerPage.getSelectedDate();
        Assert.assertEquals(selectedDate, "08/04/2025", "Selected date is incorrect!");
    }
}
