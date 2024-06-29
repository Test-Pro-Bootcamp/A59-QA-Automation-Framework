import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

        navigateToPage();
        enterEmail("christina.taylor@testpro.io");
        enterPassword("jKV0uSX6z1dv");
        submit();
        Thread.sleep(2000);
        searchSong("Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist("lazy Days");
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    public void searchSong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }
    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist (String lazyDays) throws InterruptedException {
        //We created a playlist named "Test Pro Playlist"
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();
        Thread.sleep(2000);
    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}

/*

public class Homework17 extends BaseTest {



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



    }

    public String getAddToPlaylistSuccessMsg() {
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

    public void searchSong(String name) {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(name);
    }
}

*/