import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

//import static com.sun.beans.introspect.PropertyInfo.Name.required;
//import static java.awt.SystemColor.text;

public class PlayListTests extends BaseTest{

    @Test
    public void deletePlayList() throws InterruptedException {

        // create a playlist
        createPlayListBtn(playListName);
        // search for a song
        searchSong(songName);
        // click view all button
        viewAllSongs();
        // select first song from result
        selectFirstSong();
        // click Add to Button
        addSongToBtn();
        // choose list to add song to
        choosePlayList();
        // delete the playlist
        Thread.sleep(6000);
        deletePlayListBtn();
        // actual vs expected

        Assert.assertEquals(verifyDeleteNotificationMessage(), expectedDeleteMessage);
    }

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        // create a playlist
        createPlayListBtn(playListName);
        // search for a song
        searchSong(songName);
        // click view all button
        viewAllSongs();
        // select first song from result
        selectFirstSong();
        // click Add to Button
        addSongToBtn();
        // choose list to add song to
        choosePlayList();
        // actual vs expected
        Assert.assertEquals(verifyAddNotificationMessage(), expectedAddMessage);
        deletePlayListBtn();
    }

    public void createPlayListBtn(String playListName) throws InterruptedException {
        Thread.sleep(2000);

     //  What is going on here????????

     //   WebElement selectCreateNewPlayList = driver.findElement(By.xpath("//*[@id=\"playlists\"]//i[@role=\"button\"]"));

        WebElement selectCreateNewPlayList = wait.until
                 (ExpectedConditions.visibilityOfElementLocated
                           (By.xpath("//i[@data-testid=\"sidebar-create-playlist-btn\"][@title=\"Create a new playlist\"][@class=\"fa fa-plus-circle create\"]")));
                       //      (By.xpath("//*[@id=\"playlists\"]//i[@role=\"button\"]")));
        selectCreateNewPlayList.click();

//        WebElement selectCreatePlayList = driver.findElement(By.xpath("//li[@data-testid=\"playlist-context-menu-create-simple\"][contains(text(), \"New Playlist\")]"));
        WebElement selectCreatePlayList = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//li[@data-testid=\"playlist-context-menu-create-simple\"][contains(text(), \"New Playlist\")]")));
                       //        (By.xpath("//i[@role=\"button\"][@title=\"Create a new playlist\"]")));
        selectCreatePlayList.click();


      //  WebElement selectNameField = driver.findElement(By.xpath("//input [@placeholder=\"↵ to save\"][@name=\"name\"][@required=\"required\"]"));
        WebElement selectNameField = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//input [@placeholder=\"↵ to save\"][@name=\"name\"][@required=\"required\"]")));
                     //     (By.xpath("//input[@name=\"name\"][@required=\"required\"]"));
        selectNameField.clear();
        selectNameField.sendKeys(playListName + "\n");
        Assert.assertEquals(verifyCreatedNotificationMessage(), expectedCreatedMessage);
    }

    public void deletePlayListBtn() throws InterruptedException {
    //    WebElement selectPlayList = driver.findElement(By.xpath("//a[contains(text(), 'TestPro Playlist')]"));
        WebElement selectPlayList = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//a[contains(text(), 'TestPro Playlist')]")));
        selectPlayList.click();

   //     WebElement deletePlayList = driver.findElement(By.xpath("//button[@class=\"del btn-delete-playlist\"][@title=\"Delete this playlist\"]"));
        WebElement deletePlayList= wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//button[@class=\"del btn-delete-playlist\"][@title=\"Delete this playlist\"]")));

        deletePlayList.click();

//        WebElement selectOk = driver.findElement(By.xpath("//button[@class=\"ok\"][contains(text(), OK)]"));
//        WebElement selectOk = wait.until
//                (ExpectedConditions.visibilityOfElementLocated
//                        (By.xpath("//button[@class=\"ok\"][contains(text(), OK)]")));
//        selectOk.click();

    }

    public void searchSong(String songName) throws InterruptedException {
   //     WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        WebElement searchField = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("input[type='search']")));

        searchField.clear();
        searchField.sendKeys(songName);

    }

    public void viewAllSongs() throws InterruptedException {
   //     WebElement viewAllSongsBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        WebElement viewAllSongsBtn = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllSongsBtn.click();

    }

    public void selectFirstSong() throws InterruptedException {
        WebElement selectSong = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"songResultsWrapper\"]//table[@class=\"items\"]")));
        selectSong.click();

    }

    public void addSongToBtn() throws InterruptedException {
        WebElement addTo = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        addTo.click();

    }

    public void choosePlayList() throws InterruptedException {
        WebElement chooseList = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playListName)]")));
        chooseList.click();

    }

    public String verifyDeleteNotificationMessage() {
        WebElement verifyDeleteNotification = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));

        return verifyDeleteNotification.getText();
    }

    public String verifyAddNotificationMessage() {
        WebElement verifyAddNotification = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));

        return verifyAddNotification.getText();
    }

    public String verifyCreatedNotificationMessage() {
        WebElement verifyCreatedNotification = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));

//        WebElement verifyCreatedNotification = driver.findElement
//                (By.cssSelector("div.success.show"));

        return verifyCreatedNotification.getText();
    }
}
