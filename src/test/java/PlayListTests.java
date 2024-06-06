import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedMessage = "Added 1 song into \"TestPro PlayList\"";
    //    String playListName = "TestPro Playlist";
        String songName = "grav";

        navigateToPage();
        enterEmail("james.mar@testpro.io");
        enterPassword("CUf3Hrw3");
        submit();

        //search for a song
        searchSong(songName);
       // click view all button
        viewAllSongs();
        //select first song from result
        selectFirstSong();
        //click Add to Button
        addToBtn();
        //choose list to add song to
        choosePlayList();
        //actual vs expected
        Assert.assertEquals(verifyNotificationMessage(), expectedMessage);
    }

    public void searchSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }

    public void viewAllSongs() throws InterruptedException {
        WebElement viewAllSongsBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllSongsBtn.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException {
        WebElement selectSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        selectSong.click();
        Thread.sleep(2000);
    }

    public void addToBtn() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addTo.click();
        Thread.sleep(2000);
    }

    public void choosePlayList() throws InterruptedException {
        WebElement chooseList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'TestPro Playlist')]"));
        chooseList.click();
        Thread.sleep(2000);
    }

    public String verifyNotificationMessage() {
        WebElement verifyNotification = driver.findElement(By.cssSelector("div.success.show"));
        return verifyNotification.getText();
    }
}
