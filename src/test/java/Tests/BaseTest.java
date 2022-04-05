package test.java.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import test.java.Utils.ActionUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class BaseTest {
    public static WebDriver driver;
    @BeforeClass
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
//                "--headless",
                "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Selenium Chrome/89.0.4389.82 Safari/537.36",
                "--window-size=1920,1080"
        );
        driver = new ChromeDriver(options);
        ActionUtils.openURL("https://demo.betgames.tv/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void makeScreenshotInCaseOfFailure(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            String testName = result.getName();
            SimpleDateFormat time = new SimpleDateFormat("MM_dd_HH_mm_ss");
            time.setTimeZone(TimeZone.getTimeZone("Europe/Vilnius"));
            long failTime = System.currentTimeMillis();

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("C:\\Users\\Edgar\\OneDrive\\Documents\\TestFailureScreenshots1\\" +
                    "screenshot_" + testName + "_" + time.format(failTime) + ".png"));
            System.out.println("Klaidos laikas: " + time.format(failTime));
        }
    }

}
