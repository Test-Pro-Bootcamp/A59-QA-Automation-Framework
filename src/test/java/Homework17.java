import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import page.AllSongsPage;
import page.HomePage;
import page.LoginPage;
import page.PlaylistPage;


public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {

// GIVEN: User is on the login page
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        PlaylistPage playlistPage= new PlaylistPage(driver);

// WHEN: User uses valid email and password click submit directed to home page
        loginPage.login();

// THEN: User should be able to add song dark to playlist
        String expectedSongAddMessage = "Add 1 Song into \"lazy days.\"";
        allSongsPage.searchSong("dark");
        homePage.viewAllBtn();
        allSongsPage.selectFirstSong();
        homePage.clickAddToBtn();
        playlistPage.chosePlayList();




    }

    public String getAddToPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();


    }


    public void chosePlayList() {
        WebElement chosePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        chosePlayList.click();

//  // Should I really be using this code to find an element i figured its not good sine
//  the name changes (By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'lazy days')]")));
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
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div#searchForm input[type='search']")));
        searchField.sendKeys(songName);
    }
}

