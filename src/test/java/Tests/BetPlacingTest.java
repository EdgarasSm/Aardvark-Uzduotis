package test.java.Tests;

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
                {"LITHUANIAN", "RESPONSIVE", "15,00"}
        };
    }

    @Test(dataProvider = "data for a bet")
    public void placeBetWithNumber(String language, String currentWindow, String betAmount) {
        mp.selectLanguage(language);
        mp.clickOnScreenSize(currentWindow);
        switchFrame(mp.betGamesIframe);
        WaitUtils.waitUntilElementIsDisplayedAndInDOM(mp.addRandomInBetsLip, 30);
        mp.scrollDown();
        mp.waitTillOddsUnlock();
        mp.enterBetAmount(betAmount);
        mp.selectNumberFromSector();
        clickOn(mp.placeBetButton);
        WaitUtils.waitUntilElementIsDisplayedAndInDOM(mp.betAcceptedMsg, 10);
        Assert.assertTrue(checkElementIsDisplayed(mp.betAcceptedMsg), "Message doesn't show");

    }
}