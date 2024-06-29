package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BasePage {
//HW Feedback: Use 'protected' access since it gives the subclass a chance to use the helper method or variable, while preventing a non-related class from trying to use it.
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    By soundBarVisualizer = By.cssSelector("[data-testid = 'sound-bar-play']");

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean isSongPlaying() {
        return findElement(soundBarVisualizer).isDisplayed();
    }



}