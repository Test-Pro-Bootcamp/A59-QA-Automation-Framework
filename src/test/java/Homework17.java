import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;


public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {



LoginPage loginPage = new LoginPage(driver);
HomePage homePage = new HomePage(driver);

loginPage.login();



        String expectedSongAddMessage = "Add 1 Song into \"lazy days.\"";
        //search for song
        searchSong("dark");
        //click view all button
        clickViewAllBtn();
        //select first song from result
        selectFirstSong();
        //click add to button
        clickAddToBtn();
        //choose a playlist from
        chosePlayList();



    }

    public String getAddToPlaylistMessage () {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();



}


    public void chosePlayList() {
        WebElement chosePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'lazy days')]")));
        chosePlayList.click();

    }

    public void clickAddToBtn() {
        WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        addToBtn.click();

    }

    public void selectFirstSong() {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        firstSong.click();

    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@data-test='view-all-songs-btn']")));
        viewAllBtn.click();
    }

    public void searchSong(String songName) {
        WebElement searchField =wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div#searchForm input[type='search']")));
        searchField.sendKeys(songName);
    }
}

