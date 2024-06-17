import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddMessage = "Add 1 Song into \"lazy days.\"";

        // go to web page
        navigateToPage();
        //login
        enterEmail("christina.taylor@testpro.io");
        enterPassword("jKV0uSX6z1dv");
        submit();
        Thread.sleep(1000);
        //search for song
        searchSong("dark");
        Thread.sleep(1000);
        //click view all button
        clickViewAllBtn();
        Thread.sleep(1000);
        //select first song from result
        selectFirstSong();
        Thread.sleep(1000);
        //click add to button
        clickAddToBtn();
        Thread.sleep(1000);
        //choose a playlist from
        chosePlayList();
        Thread.sleep(1000);
        //actual vs expected
        

        // *********I don't know how to fix this problem plz let me know what im doing wrong
        Assert.assertEquals(getAddToPlaylistMessage(), expectedSongAddMessage);


        Thread.sleep(1000);
    }

    public String getAddToPlaylistMessage () {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();



}


    public void chosePlayList() {
        WebElement chosePlayList = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'lazy days')]"));
        chosePlayList.click();

    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();

    }

    public void selectFirstSong() {
        WebElement firstSong = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();

    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement
                (By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songName);
    }
}
*/
