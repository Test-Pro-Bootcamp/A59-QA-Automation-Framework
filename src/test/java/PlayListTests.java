import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedMessage = "";

        navigateToPage();
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        searchSong("grav");

        //click view all button
        viewAllSongs();
        //select first song from result
        selectFirstSong();
        //click Add to Button
        addToBtn();
        //create a new playlist
        createNewPlayListForm();
        //click on the save button
        clickOnSaveBtn();

        //actual vs expected
        Assert.assertEquals(verifyNotificationMessage(), expectedMessage);
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public void viewAllSongs() throws InterruptedException {
        WebElement viewAllSongsBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllSongsBtn.click();
     //   Thread.sleep(1000);
    }

    public void selectFirstSong(){
        WebElement selectSong = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        selectSong.click();
    }

    public void addToBtn(){
        WebElement addTo = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        addTo.click();
    }

    public void addToFavoritesBtn(){
        WebElement addToFavorites = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[4]"));
        addToFavorites.click();
    }

    public void createNewPlayListForm(){
        WebElement createNewPlayList = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/input"));
        createNewPlayList.clear();
        createNewPlayList.sendKeys("JM-Play-List");
    }

    public void clickOnSaveBtn(){
        WebElement clickOnSave = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/button"));
        clickOnSave.click();
    }

    public String verifyNotificationMessage(){
        WebElement verifyNotification =driver.findElement(By.cssSelector(""));
        return verifyNotification.getText();
    }

}
