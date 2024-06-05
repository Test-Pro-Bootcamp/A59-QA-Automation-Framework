import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void  addSongToPlaylist(){

        // go to page
        navigateToPage();
        //login
        enterEmail("demo@gmail.com");
        enterPassword("te$t$tudant");
        submit();
        //search song
        searchField("music");
        //click view all button
        clickViewAllBtn();
        //select first song from result
        selectFirstSong();
        //click add button
        clickAddToBtn();

        //chose from playlist from menu
        chosePlayList();

        //actual vs expected



    }

    public void chosePlayList() {
        WebElement PlayList = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//li[contains(text),'TestPro Playlist'))"));
    }

    public void clickAddToBtn() {
        WebElement clickAddToBtn = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//button[@@data-test='all-to-btn']"));
        clickAddToBtn.click();
    }


    public void selectFirstSong() {
        WebElement selectFirstSong = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//tr[@class='add-to'][1]"));
        selectFirstSong.click();
    }


    public void clickViewAllBtn() {
        WebElement clickViewAllBtn = driver.findElement
                (By.xpath("//button[@data-test='view-all-songs-btn']"));
        clickViewAllBtn.click();

    }

    public void searchField(String dark) {
        WebElement searchSong = driver.findElement(By.cssSelector("input[type='search']"));
        searchSong.click();
        searchSong.sendKeys("SongName");



    }
}
