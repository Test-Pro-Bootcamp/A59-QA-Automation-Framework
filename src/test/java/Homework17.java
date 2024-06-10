import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


// Homework17 class extends BaseTest for Selenium test automation.
public class Homework17 extends BaseTest {

    // Test method for adding a song to a playlist.
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        // GIVEN
        // Initialization of test data.
        String nameSong = "love";
        // Write the current name of your playlist
        String namePlaylist = "First user playlist";
        String expectedSongAddedMessage = "Added 1 song into \"" + namePlaylist + ".\"";

        // WHEN
        // Performing actions: login, search for a song, select the first result, add to playlist.
        login("india.messam@testpro.io", "slcTalgy");
        Thread.sleep(2000);
        searchSong(nameSong);
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist(namePlaylist);

        // THEN
        // Asserting that the expected success message is displayed.
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    // Method to search for a song by name.
    public void searchSong(String nameSong) throws InterruptedException {
        // Locating the search field and entering the song name.
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(nameSong);
        Thread.sleep(2000);
    }

    // Method to click the "View All" button.
    public void clickViewAllBtn() throws InterruptedException {
        // Locating and clicking the "View All" button.
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    // Method to select the first song result.
    public void selectFirstSongResult() throws InterruptedException {
        // Locating and clicking the first song result.
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    // Method to click the "Add To" button.
    public void clickAddToBtn() throws InterruptedException {
        // Locating and clicking the "Add To" button.
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    // Method to choose a playlist by name.
    public void choosePlaylist(String playlistName) throws InterruptedException {
        // Locating and clicking the playlist with the specified name.
        WebElement playlist = driver.findElement(By.xpath(("//*[@id='songResultsWrapper']//*[contains(text(), '" + playlistName + "')]")));
        playlist.click();
        Thread.sleep(2000);
    }

    // Method to get the success message after adding to the playlist.
    public String getAddToPlaylistSuccessMsg() {
        // Locating and retrieving the success message.
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
