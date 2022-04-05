package test.java.Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.Page.MainPage;
import test.java.Utils.WaitUtils;

import static test.java.Utils.ActionUtils.*;

public class BetPlacingTest extends BaseTest {
    MainPage mp = new MainPage();

    @DataProvider(name = "data for a bet")
    public static Object[][] insertData() {
        return new Object[][]{
                {"LITHUANIAN", "TABLET", "DESKTOP", "10"}
        };
    }

    @Test(dataProvider = "data for a bet")
    public void placeBetWithNumber(String language, String currentWindow, String currentWindow1, String betAmount) {
        mp.selectLanguage(language);
        mp.clickOnScreenSize(currentWindow);
        mp.clickOnScreenSize(currentWindow1);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,400)");
        enterData(mp.amountInput, betAmount);
        WaitUtils.waitUntilElementIsDisplayedAndInDOM(mp.placeBetButton, 15);
        clickOn(mp.addRandomInBetsLip);
        clickOn(mp.placeBetButton);
        Assert.assertTrue(checkElementIsDisplayed(mp.betAcceptedMsg), "Message doesn't show!!! ");
    }
}