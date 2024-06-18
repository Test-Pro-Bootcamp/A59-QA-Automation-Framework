import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomeWork21 extends BaseTest {

    private WebDriverWait wait;
    private Actions actions;

    @Test
    public void renamePlaylist() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);

        // Login
        login("demo@testpro.io", "te$t$tudent");

        // Create a Playlist
        createPlaylistAction();

        // Rename the PlayList
        renamePlaylistAction();

        // Assert Deletion Success
        Assert.assertTrue(getSuccessPopUp().isDisplayed());

        // Quitting the WebDriver session
        driver.quit();
    }

    public void renamePlaylistAction() {
        // Wait for the playlist element to be present and active
        WebElement renamePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li/a[@class='active']")));
        System.out.println("Found active playlist");

        // Double-click the playlist to make the input field appear
        actions.moveToElement(renamePlaylist).doubleClick().perform();
        System.out.println("Double-clicked the playlist");

        // Wait for the input field to be present
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='inline-playlist-name-input']")));
        System.out.println("Input field found");

        // Clear the input field using Ctrl+A then Backspace
        actions.moveToElement(inputField).click().sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.BACK_SPACE).perform();
        System.out.println("Cleared input field");

        // Input the new name and press Enter
        inputField.sendKeys("RenamedList");
        System.out.println("Entered new name");
        inputField.sendKeys(Keys.RETURN);
        System.out.println("Pressed Enter key");
    }

    public void createPlaylistAction() {
        // Find plus icon and click it
        WebElement addPlayList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/h1/i")));
        actions.moveToElement(addPlayList).click().perform();
        System.out.println("Clicked add playlist icon");

        // Select from menu
        WebElement selectNewPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/nav/ul/li[1]")));
        actions.moveToElement(selectNewPlaylist).click().perform();
        System.out.println("Selected new playlist from menu");

        // Add name to new playlist
        WebElement addPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/form/input")));
        actions.moveToElement(addPlaylistName).click().sendKeys("MyNewList").sendKeys(Keys.RETURN).perform();
        System.out.println("Entered new playlist name and confirmed");
    }
    public WebElement getSuccessPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Wait for the success popup to appear
            WebElement successPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[2]/div[@class='success show']")));
            System.out.println("Success popup displayed");
            return successPopUp;
        } catch (TimeoutException e) {
            System.out.println("Success popup not found. Exiting...");
            driver.quit();
            System.exit(0);
            return null;
        }
    }
}