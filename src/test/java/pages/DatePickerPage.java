package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatePickerPage {

    private WebDriver driver;

    // Constructor
    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    private By dateInput = By.id("datePickerMonthYearInput"); // Standard date picker
    private By monthSelect = By.className("react-datepicker__month-select");
    private By yearSelect = By.className("react-datepicker__year-select");

    // Actions
    public void openDatePicker() {
        driver.findElement(dateInput).click();
    }

    public void selectMonth(String month) {
        Select monthDropdown = new Select(driver.findElement(monthSelect));
        monthDropdown.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select yearDropdown = new Select(driver.findElement(yearSelect));
        yearDropdown.selectByVisibleText(year);
    }

    public void selectDay(int day) {
        WebElement dayElement = driver.findElement(By.xpath(
                "//div[contains(@class,'react-datepicker__day') and text()='" + day + "']"));
        dayElement.click();
    }

    public void selectDate(int day, String month, String year) {
        openDatePicker();
        selectMonth(month);
        selectYear(year);
        selectDay(day);
    }

    public String getSelectedDate() {
        return driver.findElement(dateInput).getAttribute("value");
    }
}
