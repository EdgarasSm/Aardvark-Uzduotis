package test.java.Utils;

import org.openqa.selenium.*;

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
     * Enter data in input field
     *
     * @param locator By
     * @param data    String
     */
    public static void enterData(By locator, String data) {
       WebElement inputField = driver.findElement(locator);
       inputField.sendKeys(data);
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

    /**
     * Switch to specified frame
     * @param locator By
     */
    public static void switchFrame(By locator  ) {
        WebElement iframe = driver.findElement(locator);
        driver.switchTo().frame(iframe);
    }

    /**
     * Clears input field
     * @param locator By
     */
    public static void clearInputField(By locator) {
        driver.findElement(locator).clear();
    }

}
