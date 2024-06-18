import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



import java.util.List;

public class ActionTest extends BaseTest {
    @Test
    public void playSong() {
       LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);
       AllSongsPage allSongsPage = new AllSongsPage(driver);

       loginPage.provideEmail("kristina.sarkisyan@testpro.io");
       loginPage.providePassword("o8URUDnW");
       loginPage.clickSubmit();
       //loginPage.login();
        //Choose All Songs
       homePage.chooseAllSongsList();
        //Contextual Click on the first song
        allSongsPage.contextClickFirstSong();
        //Click on Play from the menu
        allSongsPage.choosePlayOption();
        Assert.assertTrue(allSongsPage.isSongPlaying());
  }


// Test #2 MouseHover
    //@Test
    public void hoverOverPlayButton(){
        enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();
        Assert.assertTrue(hoverPlay().isDisplayed());

    }
    public WebElement hoverPlay(){
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Test #3 WebElements
    //@Test
    public void countSongsInPlaylist() {
        enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();

        choosePlaylistByName("Playlist Demo");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        //count and display song names
        System.out.println("Number of Songs in the playlist: "+countSongs());
        for(WebElement e : songList){
            System.out.println(e.getText());
        }
    }
    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    //Test #4 Double Click
    String newPlaylistName = "Sample Edited Playlist";
    //@Test
    public void renamePlaylist(){
        String updatedPlaylistMsg = "Updated playlist \""+newPlaylistName+".\"";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }


}
