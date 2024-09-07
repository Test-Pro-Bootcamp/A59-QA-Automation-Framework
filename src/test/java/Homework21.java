import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String newPlaylistName = "Sample Edited Playlist";

    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
        // Step - 1 Login
        // -- note navigate to Koel app login page alread done with BeaseTest with @BeforeMethod
        enterEmail("leon.poyau@testpro.io");
        enterPassword("jTRCkwNf");
        submit();

        // Step 2 - Double-click on play to be renamed
        doubleClickPlaylist();

        // Step 3 - Enter new name to rename the playlist
        enterNewName();

        // Validate/verify that playlist was renamed via assertion
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);

    }

    // Helper Methods

    public void enterNewName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[name='name']")));
        // Used Keys.chord(Keys.CONTROL, "A") instead below
        // because playlistInputField.Clear() will not work on this text field
        // Below uses a sequence of keystrokes, Control-A then Back_space
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);

    }

    public void doubleClickPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".playlist:nth-child(4)")));
        actions.doubleClick(playlist).perform();
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}

