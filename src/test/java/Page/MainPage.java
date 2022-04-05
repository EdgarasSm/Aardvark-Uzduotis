package test.java.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import test.java.Utils.ActionUtils;
import test.java.Utils.WaitUtils;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static test.java.Tests.BaseTest.driver;
import static test.java.Utils.ActionUtils.*;

public class MainPage {

    public By logo = By.className("navbar-brand");
    public By contactsButton = By.id("contact");
    public By languageDropdownButton = By.id("language");
    public By languageList = By.cssSelector(".multi-column .dropdown-menu li");
    public By rightNavbar = By.className("navbar-right");
    public By rightNavBarList = By.cssSelector("li a");
    public By amountInput = By.id("amount-input");
    public By addRandomInBetsLip = By.cssSelector("[data-qa='button-add-random-betting-option']");
    public By placeBetButton = By.className("place-bet-button");
    public By betAcceptedMsg = By.cssSelector("[data-qa='text-bet-slip-notification']");
    public By betGamesIframe = By.id("betgames_iframe");
    public By videoContent = By.className("game-content");



    public List<String> getNavigationList() {
        return driver.findElements(By.className("navbar-right"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void selectLanguage(String language) {
        ActionUtils.clickOn(languageDropdownButton);
        WebElement languageDropdown = driver.findElement(languageDropdownButton);
        List<WebElement> languages = languageDropdown.findElements(languageList);
        WebElement currentLanguage = languages.stream().filter(i -> i.getText().contains(language)).findFirst().get();
        currentLanguage.click();
    }

    public void clickOnScreenSize(String currentWindow) {
        WebElement rightNavigation = driver.findElement(rightNavbar);
        List<WebElement> languages = rightNavigation.findElements(rightNavBarList);
        WebElement currentLanguage = languages.stream().filter(i -> i.getText().contains(currentWindow)).findFirst().get();
        currentLanguage.click();
    }

    public void selectNumberFromSector() {
        scrollDown();
        clickOn(By.cssSelector("[data-qa='button-game-item-select-5']"));
    }

    public void waitTillOddsUnlock() {
        WaitUtils.waitUntilElementIsDisplayedAndInDOM(By.cssSelector("[data-qa='text-odd-item-value']"),30);
    }

    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,450)");
    }

    public void enterBetAmount(String betAmount)  {
        clickOn(amountInput);
        enterData(amountInput, betAmount);
    }
}
