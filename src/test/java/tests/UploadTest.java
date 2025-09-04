package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadPage;

import java.io.File;

public class UploadTest extends BaseTest {

    @Test
    public void testFileUpload() {
        UploadPage uploadPage = new UploadPage(driver);

        // Go to the upload page
        uploadPage.goToUploadPage();

        // Load file from resources using class loader
        File file = new File(getClass().getClassLoader().getResource("simpleText.txt").getFile());

        // Upload file
        uploadPage.uploadFile(file);

        // Verify file upload
        String uploadedFile = uploadPage.getUploadedFileName();
        System.out.println("Uploaded File: " + uploadedFile);

        Assert.assertTrue(uploadedFile.contains("simpleText.txt"), "File was not uploaded successfully!");
    }
}
