package test.java.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;

import static test.java.Tests.BaseTest.driver;

public class ActionUtils {

    /**
     * Click on element
     *
     * @param locator By
     */
    public static void clickOn(By locator) {
        WebElement button = driver.findElement(locator);
        WaitUtils.waitUntilELementWillBeClickable(locator, 10);
        button.click();
    }

    /**
     * Checking is element displayed
     * @param locator By
     * @return boolean
     */
    public static boolean checkElementIsDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    /**
     * Enter data in field
     *
     * @param locator By
     * @param data    String
     */
    public static void enterData(By locator, String data) {
        driver.findElement(locator).sendKeys(data);
    }

    /**
     * Opens specified URL
     *
     * @param URL Just URL address
     */
    public static void openURL(String URL) throws Exception {
        try {
            if (URL.startsWith("http")) {
                driver.get(URL);
            } else {
                driver.get("https://" + URL);
            }
        } catch (UnhandledAlertException e) {
            acceptAlert();
            throw new Exception(URL + " could not be opened, because there was an error: " + e);
        } catch (TimeoutException e) {
            refreshPage();
        }
    }

    /**
     * Accept Alert messages
     */
    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * Refresh page
     */
    public static void refreshPage() {
        driver.navigate().refresh();
    }

}
