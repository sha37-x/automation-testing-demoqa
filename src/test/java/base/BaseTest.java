package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;
    private static final String REPORT_FILE = "report.html";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String screenshotPath = takeScreenshot(result);
        updateHtmlReport(result, screenshotPath);
        if (driver != null) driver.quit();
    }

    private String takeScreenshot(ITestResult result) {
        String status = (result.getStatus() == ITestResult.FAILURE) ? "FAILED" : "PASSED";
        String testName = result.getName() + "_" + status;
        String folderPath = "screenshots/";
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = folderPath + testName + "_" + timestamp + ".png";

        try {
            Files.createDirectories(Paths.get(folderPath));
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(filePath);
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    private void updateHtmlReport(ITestResult result, String screenshotPath) {
        String status = (result.getStatus() == ITestResult.FAILURE) ? "FAILED" : "PASSED";
        String testName = result.getName();

        try {
            File report = new File(REPORT_FILE);
            boolean isNew = report.createNewFile();  // creates file if it doesn't exist
            FileWriter fw = new FileWriter(report, true);
            PrintWriter pw = new PrintWriter(fw);

            if (isNew) {
                pw.println("<html><head><title>DemoQA Test Report</title></head><body>");
                pw.println("<h2>DemoQA Automation Report</h2>");
                pw.println("<table border='1' cellpadding='5' cellspacing='0'>");
                pw.println("<tr><th>Test Name</th><th>Status</th><th>Screenshot</th></tr>");
            }

            pw.println("<tr>");
            pw.println("<td>" + testName + "</td>");
            pw.println("<td>" + status + "</td>");
            pw.println("<td><a href='" + screenshotPath + "'>View</a></td>");
            pw.println("</tr>");

            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
