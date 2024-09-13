package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BasePage {
    WebDriver driver;  // first thing to do in Selenium
                        // everything requires a web driver

    WebDriverWait wait; // used to wait for web elements to become available/visible
    Actions actions;    // Contextual mouse/keyboard actions. Right-click, double-click, KeyUp,etc

    // Constructor for the BasePage class
    public BasePage(WebDriver givenDriver)  {    // Parametized Constructor used to initialize BasePage objects
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    // Next thing is Locators - First thing we do on a page is to locate Elements
    // We create a method to find Elements instead of using driver.findElement method or wait.until(ExpectedConditions)
    // We can simply use this method in all the pages (login, home, User profile, All Songs, etc) to find elements.
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void navigateToAllSongsPage() {
        By allSongsHome = By.cssSelector("#sidebar a.songs");
        findElement(allSongsHome).click();
    }

    public boolean isSongPlaying() {
        By soundBarVisualizer = By.cssSelector("div[data-testid='sound-bar-play'] img");
        return findElement(soundBarVisualizer).isDisplayed();
    }


}
