import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlayList() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"LeonPlayList.\"";

        // Step 1 - navigate to koel login page

        // navigateToPage();

        // Step 2 - login
        enterEmail("leon.poyau@testpro.io");
        enterPassword("jTRCkwNf");
        submit();

        // Step 3 - search for a song
        searchSong("dark");
        Thread.sleep(1000);

        //Step 4 - click view-all button
        clickViewAllBtn();
        Thread.sleep(1000);

        // Step 5 - select first song from search results
        selectFirstSong();
        Thread.sleep(1000);

        // Step 6 - click Add-to-button
        clickAddToBtn();
        Thread.sleep(1000);

        // Step 7 - choose a playlist from the menu
        choosePlaylist();
        Thread.sleep(1000);

        // actual vs expected via assertion
        Assert.assertEquals(getAddToPlayListMessage(),expectedSongAddedMessage);


    }

    public String getAddToPlayListMessage() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        // return notification.getText().toString();
        return notification.getText();
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'LeonPlayList')]"));
        playlist.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@class='btn-add-to']"));
        addToBtn.click();
    }

    public void selectFirstSong() {
        WebElement firstSongReturned = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSongReturned.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songName);
    }
}
