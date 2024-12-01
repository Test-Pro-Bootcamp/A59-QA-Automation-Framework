import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class PlaylistRenameTestAlternative {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private SoftAssert softAssert;
    private PlaylistOperations playlistOperations;

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(15);
    private static final Duration POLLING_INTERVAL = Duration.ofMillis(300);

    @BeforeMethod
    @Parameters("baseUrl")
    public void setupTest(@Optional("https://default-url.com") String baseUrl) {

        WebDriverManager;
        driver = WebDriverManager.edgedriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        wait = new WebDriverWait(driver, WAIT_TIMEOUT, POLLING_INTERVAL);

        actions = new Actions(driver);

        softAssert = new SoftAssert();
        playlistOperations = new PlaylistOperations(driver, wait, actions);
    }

    @Test
    @Parameters({"originalPlaylistName", "newPlaylistName"})
    public void testRenamePlaylist(
            @Optional("Old Playlist") String originalName,
            @Optional("New Playlist") String newName
    ) {
        playlistOperations.navigateToPlaylistsSection();

        boolean originalPlaylistExists = playlistOperations.verifyPlaylistExists(originalName);
        softAssert.assertTrue(originalPlaylistExists,
                "Original playlist '" + originalName + "' does not exist");

        RenameResult renameResult = playlistOperations.renamePlaylist(originalName, newName);
        softAssert.assertTrue(renameResult.isSuccessful(),
                "Failed to rename playlist from " + originalName + " to " + newName);

        softAssert.assertEquals(
                renameResult.getNotificationMessage(),
                "Playlist renamed to " + newName,
                "Rename notification text mismatch"
        );

        boolean newPlaylistExists = playlistOperations.verifyPlaylistExists(newName);
        softAssert.assertTrue(newPlaylistExists,
                "Renamed playlist '" + newName + "' not found");

        boolean originalPlaylistRemoved = !playlistOperations.verifyPlaylistExists(originalName);
        softAssert.assertTrue(originalPlaylistRemoved,
                "Original playlist still exists after renaming");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }


    private static class RenameResult {
        private boolean successful;
        private String notificationMessage;

        public RenameResult(boolean successful, String notificationMessage) {
            this.successful = successful;
            this.notificationMessage = notificationMessage;
        }

        public boolean isSuccessful() {
            return successful;
        }

        public String getNotificationMessage() {
            return notificationMessage;
        }

    private static class PlaylistOperations {
        private final WebDriver driver;
        private final WebDriverWait wait;
        private final Actions actions;

        public PlaylistOperations(WebDriver driver, WebDriverWait wait, Actions actions) {
            this.driver = driver;
            this.wait = wait;
            this.actions = actions;
        }

        public void navigateToPlaylistsSection() {
            WebElement playlistsMenu = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//nav[@id='playlist-nav']//a[contains(text(), 'Playlists')]")
                    )
            );
            playlistsMenu.click();
        }

        public boolean verifyPlaylistExists(String playlistName) {
            try {
                List<WebElement> playlists = wait.until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.xpath("//div[contains(@class, 'playlist-item') and contains(text(), '" + playlistName + "')]")
                        )
                );
                return !playlists.isEmpty();
            } catch (Exception e) {
                return false;
            }
        }

        public RenameResult renamePlaylist(String originalName, String newName) {
            try {

                WebElement playlistItem = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//div[contains(@class, 'playlist-item') and contains(text(), '" + originalName + "')]")
                        )
                );

                actions.moveToElement(playlistItem).perform();

                WebElement renameButton = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(".//button[contains(@class, 'rename-playlist-btn')]")
                        )
                );
                renameButton.click();

                WebElement renameInput = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.id("playlist-rename-input")
                        )
                );

                actions.moveToElement(renameInput)
                        .click()
                        .sendKeys(Keys.chord(Keys.CONTROL, "a"))
                        .sendKeys(Keys.BACK_SPACE)
                        .sendKeys(newName)
                        .sendKeys(Keys.ENTER)
                        .perform();

                WebElement notification = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath("//div[contains(@class, 'notification')]")
                        )
                );

                return new RenameResult(true, notification.getText());

            } catch (Exception e) {
                return new RenameResult(false, "Rename operation failed");
            }

    private static class WebDriverManager {
        public static WebDriver createDriver() {
            return null; // Replace with actual driver creation
        }
