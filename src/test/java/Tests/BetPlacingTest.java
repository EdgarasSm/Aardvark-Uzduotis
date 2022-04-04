package test.java.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.java.Page.MainPage;
import test.java.Utils.ActionUtils;
import test.java.Utils.WaitUtils;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static test.java.Utils.ActionUtils.*;

public class BetPlacingTest extends BaseTest{
    MainPage mp = new MainPage();


    public void placeBetWithNumber (String language, String currentWindow) throws InterruptedException {
        mp.selectLanguage(language);
        mp.clickOnScreenSize(currentWindow);
        mp.waitUntilOptionsWillBeClickable();



    }

//    @Test
//    public void clickOnNumberInSection() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,350)");
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-qa='button-game-item-select-5'] *span[data-qa='area-game-item-5']")));
////        WaitUtils.waitForElementToBeLocated(By.cssSelector("[data-qa='button-game-item-select-5']"),15);
//        driver.findElement(By.cssSelector("div[data-qa='button-game-item-select-5'] *span[data-qa='area-game-item-5']")).click();
//        enterData(By.id("amount-input"),"10");
//        clickOn(By.cssSelector("[data-qa='button-place-bet']"));
//    }





}
