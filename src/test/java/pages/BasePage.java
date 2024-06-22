package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;              // Import for handling lists

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    // Constructor to initialize the BasePage with a given WebDriver
    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    // Selectors
    By soundBarVisualizer = By.cssSelector("[data-testid = 'sound-bar-play']");

    // Method to wait for an element to be visible on the page
//    public WebElement waitForVisibility(By by) {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//    }

    public boolean isSongPlaying() {
        return findElement(soundBarVisualizer).isDisplayed();
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to click an element after waiting for it to be visible
    public void tryClick(By locator) {
        findElement(locator).click();
    }

    // Method to wait for an element to be present on the page
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Method to click an element after waiting for it to be present
    public void waitUntilPresentToClick(By locator) {
        waitForPresence(locator).click();
    }

    // Method to wait until all elements are visible on the page
    public List<WebElement> waitUntilAllElementsLocatedByAreVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // Method to wait until all required elements are invisible
    public boolean waitUntilRequiredElementsAreInvisible(List<WebElement> elements) {
        return wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    // Method to wait for an element to be clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to click on an element after waiting for it to be clickable
    public void click(By locator) {
        waitForClickable(locator).click();
    }

    // Method to wait for an element to be clickable and then click it
    public void waitForClickableAndClick(By locator) {
        WebElement element = waitForClickable(locator);
        element.click();
    }

    // Method to wait for an element to be clickable and then double click it
    public void waitForClickableAndDoubleClick(By locator) {
        WebElement element = waitForClickable(locator);
        element.click();
        element.click();
    }

    // Method to click an element
    public void singleClick(By locator) {
        WebElement element = waitForClickable(locator);
        actions.click(element).perform();
    }

    // Method to double-click an element
    public void doubleClick(By locator) {
        WebElement element = waitForClickable(locator);
        actions.doubleClick(element).perform();
    }

    // Method to wait for an element to be clickable
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to click an element without any wait
    public void tryClickNoWait(By locator) {
        driver.findElement(locator).click();
    }

    // Method to move the mouse over an element
    public WebElement mouseOver(By locator) {
        WebElement element = waitForVisibility(locator);

        actions.moveToElement(element).perform();
        return element;
    }

    // Method to move the mouse over an element and click it
    public void mouseOverAndClick(By locator) {
        WebElement element = waitForVisibility(locator);

        actions.moveToElement(element).click().perform();
    }

    // Method to move the mouse over an element and single click it
    public void singleClickBtn(By locator) {
        WebElement element = waitForVisibility(locator);

        actions.moveToElement(element).click().perform();
    }

    // Method to move the mouse over an element and double click it
    public void doubleClickBtn(By locator) {
        WebElement element = waitForVisibility(locator);

        actions.moveToElement(element).doubleClick().perform();
    }


    // Method to move the mouse over an element and double click it
    public void mouseOverAndDoubleClick(By locator) {
        WebElement element = waitForVisibility(locator);

        actions.moveToElement(element).doubleClick().perform();
    }

    // Method to move the mouse over an element and right click it
    public void mouseOverAndContextClick(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).contextClick().perform();
    }

    // Method to move the mouse over an element and click and hold it
    public void mouseOverAndClickAndHold(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).clickAndHold().perform();
    }

}
