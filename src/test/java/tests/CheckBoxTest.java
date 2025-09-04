package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckBoxTest extends BaseTest {

    @Test
    public void testCheckBoxSelection() {
        CheckBoxPage page = new CheckBoxPage(driver);
        page.openPage();
        page.selectClassified();

         Assert.assertTrue(driver.getPageSource().contains("classified"));
    }
}
