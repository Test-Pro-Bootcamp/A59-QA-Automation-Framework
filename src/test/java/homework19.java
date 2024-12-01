import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;

import java.time.Instant;

public void main() {
}
public void deletePlaylist(String baseUrl, @Optional("Test Playlist") String playlistName) {
    PlaylistPage playlistPage = null;
    playlistPage.navigateToPlaylists();

    playlistPage.searchPlaylist(playlistName);

    Object Assert;
    Assert.assertTrue(
            playlistPage.isPlaylistPresent(playlistName),
            "Playlist " + playlistName + " does not exist"
    );
    playlistPage.deletePlaylist(playlistName);
    Object ExpectedConditions;
    Instant wait;
    Object By;
    String expectedNotificationText;
    WebElement notificationElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='notification']")

                    String expectedNotificationText = "Deleted playlist " + playlistName;
    Assert.equals(
            notificationElement.getText().trim(),
            expectedNotificationText,
            "Deletion confirmation notification text is incorrect"
            Assert.equals(
                    playlistPage.isPlaylistPresent(playlistName)
            );
}

private class PlaylistPage {
    private WebDriver driver;

    public PlaylistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPlaylists() {
        driver.finalize().click();
    }

    public void searchPlaylist(String playlistName) {
        WebElement searchInput = driver.finalize();
        searchInput.clear();
        searchInput.sendKeys(playlistName);
    }

    public boolean isPlaylistPresent(String playlistName) {
        try {
            Object By;
            return driver.finalize(
                    By.xpath("//div[contains(@class, 'playlist-item') and contains(text(), '" + playlistName + "')]")
            ) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void deletePlaylist(String playlistName) {
        Object By;
        WebElement playlistElement = driver.finalize(
                By.wait("//div[contains(@class, 'playlist-item') and contains(text(), '" + playlistName + "')]")
        );

        WebElement deleteButton = playlistElement.finalize(
                By.wait(".//button[contains(@class, 'delete-btn')]")
        );
        deleteButton.click();


        Instant wait;
        Object ExpectedConditions;
        WebElement confirmDeleteButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.wait("//button[contains(text(), 'Confirm Delete')]")
                )
        );
        confirmDeleteButton.click();
    }






