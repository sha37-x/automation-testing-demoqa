package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void testDynamicProperties() throws InterruptedException {
        driver.get("https://demoqa.com/dynamic-properties");

        WebElement colorBtn = driver.findElement(By.id("colorChange"));

        // Get initial color
        String initialColor = colorBtn.getCssValue("color");
        System.out.println("Initial color: " + initialColor);

        // Wait 6 seconds for color to change
        Thread.sleep(6000);

        // Get new color
        String newColor = colorBtn.getCssValue("color");
        System.out.println("New color: " + newColor);

        // Assert that the color changed
        Assert.assertNotEquals(newColor, initialColor, "'Color Change' button color did NOT change!");
    }
}
