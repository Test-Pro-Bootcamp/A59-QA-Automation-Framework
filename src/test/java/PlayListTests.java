import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest{

    @Test
    public void createPlaylistThenDeleteIt() throws InterruptedException {

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
        WebElement selectCreateNewPlayList = driver.findElement(By.xpath("//*[@id=\"playlists\"]//i[@role=\"button\"]"));

        Thread.sleep(2000);
        selectCreateNewPlayList.click();
        Thread.sleep(2000);
        WebElement selectCreatePlayList = driver.findElement(By.xpath("//li[@data-testid=\"playlist-context-menu-create-simple\"][contains(text(), \"New Playlist\")]"));
        selectCreatePlayList.click();

        Thread.sleep(2000);
        WebElement selectNameField = driver.findElement(By.xpath("//input [@placeholder=\"↵ to save\"][@name=\"name\"][@required=\"required\"]"));
        selectNameField.clear();
        selectNameField.sendKeys(playListName + "\n");
        Assert.assertEquals(verifyCreatedNotificationMessage(), expectedCreatedMessage);
    }

    public void deletePlayListBtn() throws InterruptedException {
        WebElement selectPlayList = driver.findElement(By.xpath("//a[contains(text(), 'TestPro Playlist')]"));
        selectPlayList.click();
        Thread.sleep(2000);
        WebElement deletePlayList = driver.findElement(By.xpath("//button[@class=\"del btn-delete-playlist\"][@title=\"Delete this playlist\"]"));
        deletePlayList.click();
        WebElement selectOk = driver.findElement(By.xpath("//button[@class=\"ok\"][contains(text(), OK)]"));
        selectOk.click();
        Thread.sleep(2000);
    }

    public void searchSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        Thread.sleep(2000);
        searchField.clear();
        Thread.sleep(2000);
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }

    public void viewAllSongs() throws InterruptedException {
        WebElement viewAllSongsBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllSongsBtn.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException {
        WebElement selectSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]//table[@class=\"items\"]"));
        selectSong.click();
        Thread.sleep(2000);
    }

    public void addSongToBtn() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addTo.click();
        Thread.sleep(2000);
    }

    public void choosePlayList() throws InterruptedException {
        WebElement chooseList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[@class=\"playlist\"][contains(text(), playListName)]"));
        chooseList.click();
        Thread.sleep(2000);
    }

    public String verifyDeleteNotificationMessage() {
        WebElement verifyDeleteNotification = driver.findElement(By.cssSelector("div.success.show"));

        return verifyDeleteNotification.getText();
    }

    public String verifyAddNotificationMessage() {
        WebElement verifyAddNotification = driver.findElement(By.cssSelector("div.success.show"));

        return verifyAddNotification.getText();
    }

    public String verifyCreatedNotificationMessage() {
        WebElement verifyCreatedNotification = driver.findElement(By.cssSelector("div.success.show"));

        return verifyCreatedNotification.getText();
    }
}

