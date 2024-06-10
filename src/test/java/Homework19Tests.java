import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19Tests extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedSongDeletedMessage = "Deleted playlist \"homework19.\"";
        String newPlaylistName = "homework19";

        //Login
        enterEmail(email);
        enterPassword(password);
        submit();
        Thread.sleep(10000);
        //Create Playlist homework19
        createNewPlaylist(newPlaylistName);
        //Select Playlist
        selectPlaylist();
        Thread.sleep(10000);
        //Delete Playlist
        deleteSelectedList();
        Thread.sleep(10000);
        //Verify actual message with expected
        Assert.assertEquals(getDeletePlaylistMessage(), expectedSongDeletedMessage);


    }

    private String getDeletePlaylistMessage() {
        WebElement message = driver.findElement(By.cssSelector("div.success.show"));
        return message.getText();
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

    private void deleteSelectedList() {
        WebElement deleteBtn = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deleteBtn.click();


    }

    private void selectPlaylist() {
        WebElement playList = driver.findElement
                (By.xpath("//section[@id='playlists']//li[contains(normalize-space(), 'homework19')]"));
        playList.click();
    }
}
