package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage {

    WebDriver driver;

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "enableAfter")
    public WebElement enableAfterBtn;

    @FindBy(id = "colorChange")
    public WebElement colorChangeBtn;

    @FindBy(id = "visibleAfter")
    public WebElement visibleAfterBtn;

    // Actions
    public boolean isEnableAfterButtonEnabled() {
        return enableAfterBtn.isEnabled();
    }

    public boolean isVisibleAfterButtonDisplayed() {
        try {
            return visibleAfterBtn.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getColorChangeButtonColor() {
        return colorChangeBtn.getCssValue("color"); // or "background-color"
    }
}
