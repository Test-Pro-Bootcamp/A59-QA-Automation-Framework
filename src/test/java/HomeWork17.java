import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HomeWork17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"first playlist.\"";
        // navigate to page
        navigateToPage();

        //login
        enterEmail("apurva.singh@testpro.io");
        enterPassword("te$tpro$tudent1");
        submit();


        //search for song
        searchSong("BornKing");
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
        assertEquals(getAddToPlaylistMessage(), expectedSongAddedMessage);

        String url = "https://qa.koel.app/";
        driver.get(url);


    }
//Helper methods

    public String getAddToPlaylistMessage() {
        WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        return notification.getText();
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[@class='playlist'][normalize-space()='first playlist']"));
        playlist.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void selectFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[2]"));
        firstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Press F to search']"));
        searchField.sendKeys(songName);
    }


}
