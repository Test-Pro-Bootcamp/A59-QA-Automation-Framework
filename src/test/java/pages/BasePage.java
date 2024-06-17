package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class BasePage {


    ChromeOptions options = new ChromeOptions();
    String url = "https://qa.koel.app/";
    String expectedAddMessage = "Added 1 song into \"TestPro Playlist.\"";
    String expectedDeleteMessage = "Deleted playlist \"TestPro Playlist.\"";
    String expectedCreatedMessage = "Created playlist \"TestPro Playlist.\"";
    String playListName = "TestPro Playlist";
    String songName = "grav";
    String returnedString = null;
    String userName =  "demo@testpro.io";
    String userPassword = "te$t$tudent";



    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebDriver driver = null;
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    Actions actions;

    // Initialize BasePage
    // Object of this class BasePage
    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    // Need to find/get WebElements so make it very common
    public WebElement findElement(By Locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    }



    public WebElement waitForPresence(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitForPresenceOfAllElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public WebElement waitForVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitUntilAllElementsLocatedByAreVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public boolean waitUntilRequiredElementsAreInvisible(List<WebElement> elements) {
        return wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public WebElement waitForClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
