import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String nameSong = "dark";

        String namePlaylist = "TestPro Playlist";
        String expectedSongAddMessage = "Added 1 song into \"TestPro Playlist\"";


        //navigate to page
        navigateToPage();
        //login
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
        //search song
        searchSong("dark");
        //click view all btn
        clickViewAllbtn();
        //select first song
        selectFirstSong();
        //add to btn
        clickAddToBtn();
        // chose playlist
        chosePlayList();
        //actual vs expected
        Assert.assertEquals(getAddToPlayListSuccessMsg(),expectedSongAddMessage);
    }
    public String getAddToPlayListSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();


    }

    public void chosePlayList() {
        WebElement chosePlayList = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'TestPro Playlist')]"));


    }

    public void clickAddToBtn() {
        WebElement clickAddToBtn = driver.findElement
                (By.xpath("//selection[@id='songResultsWrapper']//button[@data-test='add-o-btn]"));
        clickAddToBtn.click();

    }

    public void selectFirstSong() {
       WebElement selectFirstSongResult = driver.findElement
               (By.xpath(" //section[@id='songResultWrapper']//tr[@class='song-item'][1]"));
       selectFirstSongResult.click();
    }

    public void clickViewAllbtn() {

            WebElement clickAddToBtn = driver.findElement
                    (By.xpath("//button[@data-test='view-all-songs-btn']"));
            clickAddToBtn.click();



        }

    public void searchSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement
                (By.cssSelector("div#searchFrom input[type='search']"));
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }
}