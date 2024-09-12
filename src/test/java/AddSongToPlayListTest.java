import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

//Homework 17
public class AddSongToPlayListTest extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String songName = "dark";
        homePage.enterSearchSong(songName);
        homePage.clickViewAllBtn();
        homePage.selectFirstSong();
        homePage.clickAddToBtn();
        homePage.choosePlayList();
        Assert.assertTrue(homePage.getAddToPlayListMessage().isDisplayed());
    }
        //search song
        //click view all button
//        clickViewAllBtn();
        //select first song from result
//        selectFirstSong();
        //click Add to Button
//        clickAddToBtn();
        //choose a playlist form menu
//        choosePlaylist();
        //actual vs expected
//        Assert.assertEquals(getAddToPlaylistMessage(),expectedSongAddedMessage);
//    }
//    public String getAddToPlaylistMessage(){
//        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
//        return notification.getText();

//    public void choosePlaylist() {
//        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Playlist 78')]")));
//
//        //WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Playlist 78')]"));
//        playlist.click();
//    }
//    public void clickAddToBtn() {
//        WebElement addToBth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
//
//        //WebElement addToBth = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
//        addToBth.click();
//    }
//    public void selectFirstSong() {
//        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
//        //WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
//        firstSong.click();
//    }
//    public void clickViewAllBtn() {
//        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='view-all-songs-btn']")));
//        //WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
//        viewAllBtn.click();
//    }
//    public void searchSong(String songName) {
//        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#searchForm input[type='search']")));
//        //WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
//        searchField.sendKeys(songName);
//    }


}
