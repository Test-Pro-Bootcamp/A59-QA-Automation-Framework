import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {
    private Actions actions;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        actions = new Actions(getDriver());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    // Test #1 Contextual Click
    @Test
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        loginPage.login();

        // Choose All Songs
        homePage.chooseAllSongsList();
        // Contextual Click on the first song
        allSongsPage.contextClickFirstSong();
        // Click on Play from the menu
        allSongsPage.choosePlayOption();
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() throws InterruptedException {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }

    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public boolean isPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

    @Test
    public void deletePlaylist() {
        // Instantiate LoginPage and HomePage
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Perform login
        loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!");

        // Perform delete playlist action
        homePage.selectPlayList();
        homePage.clearInfo();
        homePage.deletePlaylist();
        homePage.successPopUpBox();
    }

    // Test #2 Mouse Hover
    @Test
    public void hoverOverPlayButton() throws InterruptedException {
        enterEmail("giovanna.silva@testpro.io");
        enterPassword("ShakaMaya1302!");
        submit();
        // hover and verify play
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    public WebElement hoverPlay() {
        WebElement play = getDriver().findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    // Test #3 WebElements
    @Test
    public void countSongsInPlaylist() throws InterruptedException {
        enterEmail("giovanna.silva@testpro.io");
        enterPassword("ShakaMaya1302!");
        submit();

        choosePlaylistByName("GiosPlaylist");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public void displayAllSongs() {
        List<WebElement> songList = getDriver().findElements(By.cssSelector("section#playlistWrapper td.title"));
        // count and display song names
        System.out.println("Number of Songs in the playlist: " + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public int countSongs() {
        return getDriver().findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails() {
        return getDriver().findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    // Test #4 Double Click
    String newPlaylistName = "Sample Edited Playlist";

    // @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"" + newPlaylistName + ".\"";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}