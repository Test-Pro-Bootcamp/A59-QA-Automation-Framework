import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17Tests extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"playlist2024.\"";
        //String expectedSongAddedMessage = "Added 1 song into \"1234.\" ";
        String newPlaylistName = "playlist2024";

    //navigate to page
        navigateToPage();
    //login
        enterEmail(email);
        enterPassword(password);
        submit();
        Thread.sleep(10000);
    //I am creating new Playlist to be used later in the testB
        createNewPlaylist(newPlaylistName);
        Thread.sleep(1000);
    //search for song
        searchSong("Music");
        Thread.sleep(1000);
    //click view all button
        clickViewAllButton();
        Thread.sleep(1000);
    //select first song from results
        clickFirstSongInList();
        Thread.sleep(1000);
    //click add to button
        clickAddToButton();
        Thread.sleep(1000);
    //choose a playlist from menu to add song
        //playlist1 must be added
        //addToNewPlayList(newPlaylistName);
        choosePlaylist();
        Thread.sleep(1000);
    //Compare actual vs expected
        Assert.assertEquals(getAddSongSuccessMessage(), expectedSongAddedMessage);

    }

    private void createNewPlaylist(String newPlaylistName) {
        WebElement addPlayLists = driver.findElement(By.cssSelector("i[title='Create a new playlist']"));
        addPlayLists.click();
        WebElement newPlaylistChoice = driver.findElement
                (By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistChoice.click();
        WebElement inputNewPlaylist = driver.findElement(By.cssSelector("#playlists input[type='text']"));
        inputNewPlaylist.sendKeys(newPlaylistName);
        inputNewPlaylist.submit();
    }
    private void addToNewPlayList(String newPlaylistName) {
        WebElement newPlaylist = driver.findElement
                (By.cssSelector("#songsWrapper section.new-playlist input[type='text']"));
        newPlaylist.sendKeys(newPlaylistName);
        WebElement submit = driver.findElement(By.cssSelector("#songsWrapper button[type='submit']"));
        submit.click();
    }

    private String getAddSongSuccessMessage() {
        WebElement message = driver.findElement(By.cssSelector("div.success.show"));
        return message.getText();
    }

    private void choosePlaylist() {
        //WebElement listItem = driver.findElement
        // (By.cssSelector("#songsWrapper .existing-playlists ul :nth-child(5)"));
        WebElement listItem = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'playlist2024')]"));
        listItem.click();
    }

    private void clickAddToButton() {
        WebElement addToListButton = driver.findElement(By.cssSelector("#songResultsWrapper button[data-test='add-to-btn']"));
        addToListButton.click();
    }

    private void clickFirstSongInList() {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper tr[class='song-item']:nth-child(1)"));
        firstSong.click();
    }

    private void clickViewAllButton() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }


    private void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }


}
