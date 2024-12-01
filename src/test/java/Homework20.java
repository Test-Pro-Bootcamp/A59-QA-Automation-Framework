import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class PlaylistDeletionTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private PlaylistManager playlistManager;

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(15);
    private static final Duration POLLING_INTERVAL = Duration.ofMillis(500);

    @BeforeMethod
    @Parameters("baseUrl")
    public void setupTest(@Optional("https://default-url.com") String baseUrl) {

        WebDriverInitializer WebDriverInitializer;
        driver = WebDriverInitializer.createDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        wait = new WebDriverWait(driver, WAIT_TIMEOUT, POLLING_INTERVAL);

        playlistManager = new PlaylistManager(driver, wait);
    }

    @Test
    @Parameters({"playlistName"})
    public void testDeletePlaylist(@Optional("Weekend Playlist") String playlistName) {

        playlistManager.navigateToPlaylistsPage();

        boolean playlistExists = playlistManager.verifyPlaylistExists(playlistName);
        SoftAssert softAssert;
        softAssert.assertTrue(playlistExists,
                "Playlist '" + playlistName + "' does not exist before deletion");

        boolean deletionResult = playlistManager.deletePlaylist(playlistName);
        softAssert.assertTrue(deletionResult,
                "Failed to delete playlist: " + playlistName);

        String notificationMessage = playlistManager.getNotificationMessage();
        softAssert.assertEquals(
                notificationMessage,
                "Deleted playlist " + playlistName,
                "Deletion notification text mismatch"
        ):
        boolean playlistRemoved = playlistManager.verifyPlaylistRemoved(playlistName);
        softAssert.assertTrue(playlistRemoved,
                "Playlist was not successfully deleted");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static class PlaylistManager {
        private final WebDriver driver;
        private final WebDriverWait wait;

        public PlaylistManager(WebDriver driver, WebDriverWait wait) {
            this.driver = driver;
            this.wait = wait;
        }

        public void navigateToPlaylistsPage() {
            WebElement playlistsMenu = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//nav[@id='main-menu']//a[contains(text(), 'Playlists')]")
                    )
            );
            playlistsMenu.click();
        }

        public boolean verifyPlaylistExists(String playlistName) {
            try {
                WebElement playlist = wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//div[contains(@class, 'playlist-item') and contains(text(), '" + playlistName + "')]")
                        )
                );
                return playlist.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }

        public boolean deletePlaylist(String playlistName) {
            try {

                WebElement playlistItem = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[contains(@class, 'playlist-item') and contains(text(), '" + playlistName + "')]")
                        )
                );

                WebElement deleteButton = playlistItem.findElement(
                        By.xpath(".//button[contains(@class, 'delete-btn')]")
                );
                deleteButton.click();

                WebElement confirmButton = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//button[contains(text(), 'Confirm Delete')]")
                        )
                );
                confirmButton.click();

                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public String getNotificationMessage() {
            WebElement notification = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[contains(@class, 'notification')]")
                    )
            );
            return notification.getText().trim();
        }

        public boolean verifyPlaylistRemoved(String playlistName) {
            try {
                wait.until(
                        ExpectedConditions.invisibilityOfElementLocated(
                                By.xpath("//div[contains(@class, 'playlist-item') and contains(text(), '" + playlistName + "')]")
                        )
                );
                return true;
            } catch (Exception e) {
                return false;
            }
            {
    // Utility class for WebDriver initialization
    private static class WebDriverInitializer {
        public static WebDriver createDriver() {
            // Implement your preferred driver initialization
            // (e.g., ChromeDriver, WebDriverManager, etc.)
            return null; // Replace with actual driver creation

        }