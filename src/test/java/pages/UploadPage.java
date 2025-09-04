package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class UploadPage {

    private WebDriver driver;

    // Constructor
    public UploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    // WebElements
    @FindBy(id = "uploadFile")
    private WebElement uploadInput;

    @FindBy(id = "uploadedFilePath")
    private WebElement uploadedFilePath;

    // Actions
    public void goToUploadPage() {
        driver.get("https://demoqa.com/upload-download");
    }

    public void uploadFile(File file) {
        uploadInput.sendKeys(file.getAbsolutePath());
    }

    public String getUploadedFileName() {
        return uploadedFilePath.getText();
    }
}
