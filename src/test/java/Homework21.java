import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Homework21 extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(Homework21.class);
    private WebDriverWait wait;
    private Actions actions;

    @Test
    public void renamePlaylist() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        String newPlaylistName = "Love";
        String updatedPlaylistMsg = "Updated playlist \"" + newPlaylistName + "\".";

        // Login
        login("india.messam@testpro.io", "slcTalgy");

        // Navigate to the playlist and double-click it
        doubleClickPlaylist();

        // Enter the new playlist name
        enterNewPlaylistName(newPlaylistName);

        // Verify the playlist name has been changed
        String actualMessage = getRenamePlaylistSuccessMsg();
        Assert.assertEquals(actualMessage, updatedPlaylistMsg, "Updated playlist love");
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/95793']")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(String newPlaylistName) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}











