package test.java.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.Utils.ActionUtils;
import test.java.Utils.WaitUtils;

import java.util.List;
import java.util.stream.Collectors;

import static test.java.Tests.BaseTest.driver;

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
    public By betAcceptedMsg = By.className("UNDqg9DOBn0zrKbJbM3Q");



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
        System.out.println(currentLanguage);
    }

    public void clickOnScreenSize(String currentWindow) {
        WebElement rightNavigation = driver.findElement(rightNavbar);
        List<WebElement> languages = rightNavigation.findElements(rightNavBarList);
        WebElement currentLanguage = languages.stream().filter(i -> i.getText().contains(currentWindow)).findFirst().get();
        currentLanguage.click();
    }

    public void waitUntilOptionsWillBeClickable() {
        WaitUtils.waitUntilELementWillBeClickable(By.xpath("//*[@data-qa='area-game-item-1']"),50);
    }
}
