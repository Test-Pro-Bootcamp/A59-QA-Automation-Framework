package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;              // Import for handling lists

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    // Constructor to initialize the BasePage with a given WebDriver
    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Selectors
    @FindBy(css = "[data-testid = 'sound-bar-play']")
    private WebElement soundBarVisualizer;

    // Method to wait for an element to be visible on the page
    //    public WebElement waitForVisibility(By by) {
    //        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    // }

    public boolean isSongPlaying() {

        return soundBarVisualizer.isDisplayed();
    }

//    protected WebElement findElement(WebElement webElement) {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
//    }

    protected WebElement findElement(WebElement webElement) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
    }

    // Method to wait for an element to be present on the page
    protected WebElement waitForPresence(WebElement webElement) {

        return wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement));
    }

    // Method to click an element after waiting for it to be present
    protected void waitUntilPresentToClick(WebElement webElement) {

        waitForPresence(webElement).click();
    }

    // Method to wait until all elements are visible on the page
    public List<WebElement> waitUntilAllElementsLocatedByAreVisible(WebElement webElement) {

        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) webElement));
    }

    // Method to wait until all required elements are invisible
    public boolean waitUntilRequiredElementsAreInvisible(List<WebElement> elements) {

        return wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    // Method to wait for an element to be clickable
    protected WebElement waitForClickable(WebElement webElement) {

        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    // Method to click on an element after waiting for it to be clickable
    protected void click(WebElement webElement) {

        waitForClickable(webElement).click();
    }

    // Method to wait for an element to be clickable and then click it
    protected void waitForClickableAndClick(WebElement webElement) {

        WebElement element = waitForClickable(webElement);

        element.click();
    }

    // Method to wait for an element to be clickable and then double click it
    protected void waitForClickableAndDoubleClick(WebElement webElement) {

        WebElement element = waitForClickable(webElement);

        element.click();
        element.click();
    }

    // Method to click an element
    protected void singleClick(WebElement webElement) {

        WebElement element = waitForClickable(webElement);

        actions.click(element).perform();
    }

    // Method to double-click an element
    protected void doubleClick(WebElement webElement) {

        WebElement element = waitForClickable(webElement);

        actions.doubleClick(element).perform();
    }

    // Method to wait for an element to be clickable
    protected WebElement waitForVisibility(WebElement webElement) {
//
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
    }

    // Method to click an element without any wait
    protected void tryClickNoWait(WebElement webElement) {

        webElement.click();
    }

    // Method to click an element after waiting for it to be visible
    protected void tryClick(WebElement webElement) {

        webElement.click();
    }

    // Method to move the mouse over an element
    protected void mouseOver(WebElement webElement) {

        WebElement element = waitForVisibility(webElement);

        actions.moveToElement(element).perform();
    }

    // Method to move the mouse over an element and click it
    protected void mouseOverAndClick(WebElement webElement) {

        WebElement element = waitForVisibility(webElement);

        actions.moveToElement(element).click().perform();
    }

    // Method to move the mouse over an element and single click it
    protected void singleClickBtn(WebElement webElement) {

        WebElement element = waitForVisibility(webElement);

        actions.moveToElement(element).click().perform();
    }

    // Method to move the mouse over an element and double click it
    protected void doubleClickBtn(WebElement webElement) {

        WebElement element = waitForVisibility(webElement);

        actions.moveToElement(element).doubleClick().perform();
    }

    // Method to move the mouse over an element and double click it
    protected void mouseOverAndDoubleClick(WebElement webElement) {

        WebElement element = waitForVisibility(webElement);

        actions.moveToElement(element).doubleClick().perform();
    }

    // Method to move the mouse over an element and right click it
    protected void mouseOverAndContextClick(WebElement webElement) {

        WebElement element = driver.findElement((By) webElement);

        actions.moveToElement(element).contextClick().perform();
    }

    // Method to move the mouse over an element and click and hold it
    protected void mouseOverAndClickAndHold(WebElement webElement) {

        WebElement element = driver.findElement((By) webElement);

        actions.moveToElement(element).clickAndHold();
    }
}
