import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class HomeTests extends BaseTest {

    @Test
    public void HoverOverPlayBtnAndPlaySong() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

//      WHEN
        loginPage.login();
        Thread.sleep(2000);
        driver.navigate().refresh();
        homePage.mouseOverBtn();
        homePage.selectPlaylistToSingleClick();
        driver.navigate().refresh();
        homePage.mouseOverPlayBtn();
        homePage.selectPlayBtnToSingleClick();

//      THEN
        Thread.sleep(2000);
        Assert.assertTrue(homePage.selectSoundBars().isDisplayed());
    }
    @Test
    public void renamePlayList() throws InterruptedException{

        String newPlaylistName = "Sample Edited Playlist";
        String expectedRenameVerificationMsg = "Updated playlist \"" + newPlaylistName + ".\"" ;

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

//      WHEN
        loginPage.login();
        Thread.sleep(2000);

        driver.navigate().refresh();
        //  move mouse over to playlist
        homePage.mouseOverPlayBtn();
        //  double-click on playList Name
        homePage.selectPlayBtnToDoubleClick();
        //  Enter new Name
        enterNewName();

//      THEN
        Assert.assertEquals(homePage.selectRenameVerifyNotificationMsg(), expectedRenameVerificationMsg);
    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

//      WHEN
        loginPage.login();
        //Choose a Playlist by Name
        homePage.selectPlaylistByName();
//        homePage.selectPlaylistByName();
        //DisplayAllSongs
        homePage.selectDisplayAllSongs();
//        displayAllSongs();

        //Number of Songs are equal to number of songs displayed in the info section

//      THEN
        Assert.assertTrue(homePage.selectPlaylistDetails().contains(String.valueOf(songsCount())));
    }


//  Helper Methods

    public void playlistByName(String playlistName) {

        HomePage homePage = new HomePage(driver);

        homePage.selectPlaylistByName();

//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements
                (By.cssSelector("section#playlistWrapper td.title"));

        //count and display song names
        System.out.println("Number of Songs found:  " + songsCount());

        for (WebElement e: songList) {
            System.out.println(e.getText());
        }
    }

    public int songsCount() {

        HomePage homePage = new HomePage(driver);

        return homePage.selectSongCount();

//        return driver.findElements(
//                By.cssSelector("section#playlistWrapper td.title")).size();

    }

    public String playlistDetails() {
        HomePage homePage = new HomePage(driver);

        return homePage.selectPlaylistDetails();
    }

//    public String getPlaylistDetails() {
//        return driver.findElement
//                (By.cssSelector("span.meta.text-secondary span.meta")).getText();
//    }


//    public boolean isSongPlaying() {

//        WebElement soundBarVisualizer = wait.until
//                (ExpectedConditions.visibilityOfElementLocated
//                        (By.cssSelector("[data-testid = 'sound-bar-play'")));
//
//        return soundBarVisualizer.isDisplayed();


//        WebElement soundBarVisualizer = wait.until
//                (ExpectedConditions.visibilityOfElementLocated
//                        (By.cssSelector("[data-testid = 'sound-bar-play")));
//
//        return soundBarVisualizer.isDisplayed();
//    }

    public void hoverOverPlayBtn() {

        HomePage homePage = new HomePage(driver);

        homePage.mouseOverPlayBtn();
    }

    public void hoverOverPlaylist() {

        HomePage homePage = new HomePage(driver);

        homePage.selectPlaylistToSingleClick();
    }

    public void singleClickPlayList() {

        HomePage homePage = new HomePage(driver);

        homePage.selectPlaylistToSingleClick();
    }

    public void singleClickPlayBtn() {

        HomePage homePage = new HomePage(driver);

        homePage.selectPlayBtnToSingleClick();
    }

    public void doubleClickPlayBtn() {

        HomePage homePage = new HomePage(driver);

        homePage.selectPlayBtnToDoubleClick();
    }

    public void doubleClickPlayList()  {

        HomePage homePage = new HomePage(driver);

        homePage.selectPlaylistToDoubleClick();
    }

    public void findSoundBars() throws InterruptedException {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.selectSoundBars().isDisplayed());
    }

    public void enterNewName() {

        HomePage homePage = new HomePage(driver);

        homePage.selectPlaylistFieldName();

//        playListInputField.clear(); Does not work here
//        Use Send Control-A sequence then a Backspace sequence
//        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"A"), Keys.BACK_SPACE);
//        playListInputField.sendKeys(newPlaylistName);
//        playListInputField.sendKeys(Keys.ENTER);
    }

    public void renamePlaylist() {

        String updatedPlayListMsg = "Updated playlist \"Sample Edited Playlist.\"";

        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);

        //  homePage.mouseOverAndDoubleClick(playlistName);
        //  homePage.selectPlaylistToEditBtn();
        homePage.selectPlaylistFieldName();

        Assert.assertEquals(homePage.selectRenamePlaylistSuccessMsg(), updatedPlayListMsg);

    }

}
