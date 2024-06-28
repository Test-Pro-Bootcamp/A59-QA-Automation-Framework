import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Homework20 extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(Homework20.class);
    private WebDriverWait wait;
    private WebElement driver;

    @Test
    public void deletePlaylist() {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Second user playlist.\"";

        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriver driver = null;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Starting deletePlaylist test");

        // Login method needs to be implemented or inherited
        login("india.messam@testpro.io", "slcTalgy");

        // Open the playlist if necessary (not called in original code)
        openPlaylist();

        // Click on delete playlist button
        clickDeletePlaylistBtn();

        // Verify the deletion message
        String actualMessage = getDeletedPlaylistMsg();
        Assert.assertEquals(actualMessage, expectedPlaylistDeletedMessage);

        logger.info("deletePlaylist test completed successfully");
    }

    private void login(String mail, String slcTalgy) {

    }

    public void openPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("[href='#!/playlist/96187']"));
        playlist.click();
        logger.info("Opened playlist");
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del.btn-delete-playlist")));
        deletePlaylist.click();
        logger.info("Clicked delete playlist button");
    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String message = notificationMsg.getText();
        logger.info("Retrieved deletion message: {}", message);
        return message;
    }
}
