package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage {

    WebDriver driver;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstNameInput;

    @FindBy(id = "lastName")
    WebElement lastNameInput;

    @FindBy(id = "userEmail")
    WebElement emailInput;

    @FindBy(id = "age")
    WebElement ageInput;

    @FindBy(id = "salary")
    WebElement salaryInput;

    @FindBy(id = "department")
    WebElement departmentInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='rt-tbody']/div")
    List<WebElement> allRows;

    @FindBy(xpath = "//div[@class='rt-tbody']/div[1]//span[@title='Delete']")
    WebElement firstRowDeleteBtn;

    // JS click helper
    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Actions
    public void clickAdd() {
        jsClick(addButton);
    }

    public void addRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        emailInput.clear();
        emailInput.sendKeys(email);

        ageInput.clear();
        ageInput.sendKeys(age);

        salaryInput.clear();
        salaryInput.sendKeys(salary);

        departmentInput.clear();
        departmentInput.sendKeys(department);

        jsClick(submitButton);
    }

    public void deleteFirstRecord() {
        jsClick(firstRowDeleteBtn);
    }

    public void printAllTableData() {
        System.out.println("-----TABLE DATA-----:");
        for (WebElement row : allRows) {
            System.out.println(row.getText());
        }
    }
}
