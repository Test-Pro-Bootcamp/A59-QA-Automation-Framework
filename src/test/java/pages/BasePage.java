package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public WebElement findElement(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

// is this the right way to add double clicks ect.. to basePage ? or should i not be adding it to.

    public WebElement checkDoubleClick(By locator ) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public WebElement checkClickable (By locator ) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public WebElement checkHoverOver(By locator ) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}


