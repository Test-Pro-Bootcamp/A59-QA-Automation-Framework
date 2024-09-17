import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class HomeTestLesson21 extends BaseTest {

    String playListName = "Sample Edited Playlist";
    String playListForTest = "testplaylist 22";
    @Test
    public void HoverOverPlayButtonAndPlaySong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        Assert.assertTrue(homePage.getHoverPlay().isDisplayed());
    }

    @Test
    public void countSongsInPlayList(){
        loginPage.login();
        //Choose Playlist by Name
        homePage.clickChoosePlayListByName(playListForTest);
        //DisplayAllSongs
        displayAllSongs();
        //Number of songs equal to number of songs displayed in the into section.
        Assert.assertTrue(getPlayListDetails().contains(String.valueOf(songsCount())));
    }

    @Test
    public void renamePlaylist(){
        String updatedPlayListMsg = "Updated playlist \"Sample Edited Playlist.\"";
        //login
        loginPage.login();
        //Enter New Name
        homePage.enterNewNamePlayList(playListName);
        Assert.assertTrue(homePage.getRenamePlayListSuccessMsg(updatedPlayListMsg).isDisplayed());

    }

    public String getPlayListDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public int songsCount(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void displayAllSongs(){
        List<WebElement> songList = driver.findElements
                (By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: "+songsCount());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }
}
