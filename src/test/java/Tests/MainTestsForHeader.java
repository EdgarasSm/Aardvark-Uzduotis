package test.java.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.Page.MainPage;
import test.java.Utils.ActionUtils;
import test.java.Utils.WaitUtils;

import java.util.List;

public class MainTestsForHeader extends BaseTest {
    MainPage mp = new MainPage();

    @Test
    public void checkLogoIsDisplayed () {
        boolean logoIsVisible = ActionUtils.checkElementIsDisplayed(mp.logo);
        Assert.assertTrue(logoIsVisible, "Check logo, something wrong");
    }

    @Test(priority = 1)
    public void checkContactUsButtonIsDisplayed () {
        boolean contactButtonIsVisible = ActionUtils.checkElementIsDisplayed(mp.contactsButton);
        Assert.assertTrue(contactButtonIsVisible, "Check Contact Us button, something wrong");
    }

    @Test(priority = 2)
    public void checkLanguageButtonIsDisplayed() {
        boolean languageButtonIsVisible = ActionUtils.checkElementIsDisplayed(mp.languageDropdownButton);
        Assert.assertTrue(languageButtonIsVisible, "Check language dropdown");
    }

    @Test(priority = 3)
    public void printRightNavigationList () {
        List<String> rightNavigationList = mp.getNavigationList();
        System.out.println(rightNavigationList);
    }

    @Test(priority = 4)
    public void checkIfVideoIsPlaying () {
        ActionUtils.switchFrame(mp.betGamesIframe);
        WaitUtils.waitForElementToBeLocated(mp.videoContent,15);
        boolean videoIsVisible = ActionUtils.checkElementIsDisplayed(mp.videoContent);
        Assert.assertTrue(videoIsVisible, "Something wrong, video doesn't show on page.");
    }

}
