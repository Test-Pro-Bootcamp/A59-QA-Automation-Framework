import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

public class Homework20 extends BaseTest {
    @Test
    @Parameters({"BaseURL"})
    public void deletePlayList(String baseURL) throws InterruptedException, AWTException {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"LeonPlayList2.\"";
        String expectedPlaylistCreatedMessage = "Created playlist \"LeonPlayList2.\"";
        Robot robot = new Robot();
        // Pre-condition - navigate to login page for Koel app
        // navigateToPage(baseURL); // now being done by @BeforeMethod launchBrowser(String baseURL)

        // Step 1 - Login
        enterEmail("leon.poyau@testpro.io");;
        enterPassword("jTRCkwNf");
        submit();

        // Step 2 - Create a new playlist to be deleted.
        createPlayList("LeonPlayList2");

        // Thread.sleep(2000);
        robot.delay(2000); // The div.success.show message lasts too long so this delay is needed to avoid sync issues.

        // Validate and verify playlist was created via actual vs expected assertion
        Assert.assertEquals(getCreatePlayListMessage(), expectedPlaylistCreatedMessage );

        // Step 3 - Click playlist you want to delete
        clickOnPlaylist();
        robot.delay(1000);
        //Thread.sleep(1000);

        // Step 4 - Click on Delete playlist button
        clickDelPlaylistBtn();
        robot.delay(2000); // This delay is needed to avoid sync issues for Assertion line below.
        //Thread.sleep(2000);

        /*
        //Step 4 - Click on OK button on dialog box to confirm intent to delete
        // this step is done only for a playlist that isn't empty
        clickOkToDelete();
        Thread.sleep(1000);
        */

        // Validate and verify playlist deleted via actual vs expected assertion.
        Assert.assertEquals(getDelPlayListMessage(),expectedPlaylistDeletedMessage);
    }

    public void createPlayList(String playListName) {
        WebElement createNewPlayListBtn = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//i[@data-testid='sidebar-create-playlist-btn']")));
                createNewPlayListBtn.click();
        WebElement createNewPlayListMenu = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='menu playlist-menu']//li[1]")));
                createNewPlayListMenu.click();
        WebElement inputPlNameTxtBox = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//form[@class='create']/input")));
                inputPlNameTxtBox.sendKeys(playListName);
                inputPlNameTxtBox.sendKeys(Keys.ENTER);
    }

    private String getDelPlayListMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }

    private String getCreatePlayListMessage() {
        WebElement notify = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notify.getText();
    }

    // This method is to be used if Playlist is not empty and requires Ok confirm on delete dialog box
    public void clickOkToDelete() {
        WebElement okBtn = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dialog']//button[@class='ok']")));
        //WebElement okBtn = driver.findElement(
        //        By.xpath("//div[@class='dialog']//button[@class='ok']"));
        okBtn.click();
    }

    public void clickDelPlaylistBtn() {
        WebElement playlistDelBtn = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']")));
//        WebElement playlistDelBtn = driver.findElement(
//                By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']"));
        playlistDelBtn.click();
    }

    public void clickOnPlaylist() {
        WebElement playList = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul/li[4]/a")));
        /*
        WebElement playList = driver.findElement(
                By.xpath("//section[@id='playlists']//ul/li[4]/a"));

         */
        playList.click();
    }
}
