<<<<<<< Updated upstream
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"TestPro Playlist.\"";
        // navigate to page
        navigateToPage();

        //login
        enterEmail("apurva.singh@testpro.io");
        enterPassword("Acidrain1");
        submit();


        //search for song
        searchSong("dark");
        Thread.sleep(1000);

        // click to view all button
        clickViewAllBtn();
        Thread.sleep(1000);
        //select first song
        selectFirstSong();
        Thread.sleep(1000);
        //click add to button
        clickAddToBtn();
        Thread.sleep(1000);
        //choose the playlist
        choosePlaylist();
        Thread.sleep(1000);
        //actual vs expected
        Assert.assertEquals(getAddToPlaylistMessage(), expectedSongAddedMessage);

        String url = "https://qa.koel.app/";
         driver.get(url);


    }
//Helper methods

      public String getAddToPlaylistMessage() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement
                (By.xpath("//selection[@id='songResultsWrapper']//li[contains(text().'Testpro Playlist')]"));
        playlist.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement
                (By.xpath("//selection[@d= 'songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void selectFirstSong() {
        WebElement firstSong = driver.findElement
                (By.xpath("//selection[@id='songResultsWrapper']tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search]"));
        searchField.sendKeys(songName);
    }


=======
public class Homework17 {
>>>>>>> Stashed changes
}
