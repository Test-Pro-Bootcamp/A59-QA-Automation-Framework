import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

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
        searchSong("dark");
       // Thread.sleep(1000);

        // click to view all button
        clickViewAllBtn();
        //Thread.sleep(1000);
        //select first song
        selectFirstSong();
        //Thread.sleep(1000);
        //click add to button
        clickAddToBtn();
        //Thread.sleep(1000);
        //choose the playlist
        choosePlaylist();
        //Thread.sleep(1000);
        //actual vs expected
        Assert.assertEquals(getAddToPlaylistMessage(), expectedSongAddedMessage);

        String url = "https://qa.koel.app/";
        driver.get(url);


    }
//Helper methods

    public String getAddToPlaylistMessage() {
        //WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        WebElement notification = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class='success show']")));
        return notification.getText();
    }

    public void choosePlaylist() {
       // WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[@class='playlist'][normalize-space()='first playlist']"));
        WebElement playlist = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//section[@id='songResultsWrapper']//li[@class='playlist'][normalize-space()='first playlist']")));
        playlist.click();
    }

    public void clickAddToBtn() {
       // WebElement addToBtn = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        WebElement addToBtn = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//button[@data-test='add-to-btn']")));
        addToBtn.click();
    }

    public void selectFirstSong() {
        //WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[2]"));
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[2]")));
        firstSong.click();
    }

    public void clickViewAllBtn() {
      //  WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@data-test='view-all-songs-btn']")));
        viewAllBtn.click();
    }

    public void searchSong(String songName) {
       // WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Press F to search']"));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@placeholder='Press F to search']")));
        searchField.sendKeys(songName);
    }


}
