package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckBoxPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@title='Toggle']")  // expand root (Home)
    private WebElement expandHome;

    @FindBy(xpath = "//span[text()='Documents']/ancestor::label/preceding-sibling::button")
    private WebElement expandDocuments;

    @FindBy(xpath = "//span[text()='Office']/ancestor::label/preceding-sibling::button")
    private WebElement expandOffice;

    @FindBy(xpath = "//span[text()='Classified']")
    private WebElement classified;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void jsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void openPage() {
        driver.get("https://demoqa.com/checkbox");
    }

    public void selectClassified() {
        jsClick(expandHome);       // expand Home
        jsClick(expandDocuments);  // expand Documents
        jsClick(expandOffice);     // expand Office
        jsClick(classified);       // finally click Classified checkbox
    }
}
