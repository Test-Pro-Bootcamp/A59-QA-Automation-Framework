import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork19 extends BaseTest {

    @Test
    public void deletePlaylist() {
        String playlistName = "Test";
        String expectedDeletedPlaylist = "Deleted playlist \"" + playlistName + "\"";

        // Perform login actions
        enterEmail();
        enterPassword();
        submit();

        // Choose and delete the playlist
        choosePlaylist(playlistName);
        deleteSelectedPlaylist();

        // Capture the actual success message
        String actualMessage = getDeletePlaylistSuccessMsg();
        System.out.println("Actual success message: " + actualMessage);

        // Assert that the actual message matches the expected message
        Assert.assertEquals(actualMessage, expectedDeletedPlaylist, "The actual success message did not match the expected message.");

        // Verify the playlist is actually deleted
        boolean isPlaylistDeleted = verifyPlaylistDeleted(playlistName);
        Assert.assertTrue(isPlaylistDeleted, "The playlist was not deleted successfully.");
    }

    public void deleteSelectedPlaylist() {
        // Wait for the delete playlist button to be clickable and then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds wait
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Delete this playlist']")));
        deletePlaylistBtn.click();

        // Add a log statement to confirm the button was clicked
        System.out.println("Delete playlist button clicked.");
    }

    public void choosePlaylist(String playlistName) {
        // Wait for the playlist to be clickable and then click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds wait
        WebElement playlistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(playlistName)));
        playlistToDelete.click();

        // Add a log statement to confirm the playlist was selected
        System.out.println("Playlist '" + playlistName + "' selected.");
    }

    public String getDeletePlaylistSuccessMsg() {
        // Wait for the success message to be visible and capture its text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds wait
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String message = notification.getText();

        // Add a log statement to confirm the success message was captured
        System.out.println("Success message captured: " + message);

        return message;
    }

    public boolean verifyPlaylistDeleted(String playlistName) {
        try {
            // Wait for a short period to ensure any changes are reflected
            Thread.sleep(2000);

            // Try to find the placeholder message indicating the playlist is empty
            WebElement placeholderMessage = driver.findElement(By.cssSelector("div[data-test='screen-placeholder'] .text"));
            String placeholderText = placeholderMessage.getText();

            // If the placeholder text is found, it means the playlist is deleted and empty
            return placeholderText.contains("The playlist is currently empty.");
        } catch (Exception e) {
            // If an exception is thrown, it means the playlist placeholder is not found, hence playlist might not be deleted
            return false;
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Do not close the browser here to allow for inspection after test failure
        // driver.quit(); // Comment out this line
    }

    @Override
    public String toString() {
        return "HomeWork19 Test Class";
    }
}