package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    @FindBy(id = "datePickerMonthYearInput")
    private WebElement dateInput;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthDropdown;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearDropdown;

    // Actions
    public void openDatePicker() {
        dateInput.click();
    }

    public void selectMonth(String month) {
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);
    }

    public void selectDay(int day) {
        WebElement dayElement = driver.findElement(By.xpath(
                "//div[contains(@class,'react-datepicker__day') " +
                        "and not(contains(@class,'--outside-month')) and text()='" + day + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dayElement);
    }

    public void selectDate(int day, String month, String year) {
        openDatePicker();
        selectMonth(month);
        selectYear(year);
        selectDay(day);
    }

    public String getSelectedDate() {
        return dateInput.getAttribute("value");
    }
}
