import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import java.util.List;

public class HomeTest extends BaseTest {

    String newPlaylistName = "Sample Edited Playlist";

    @Test
    public void HoverPLayButtonAndPlaySongs() {

        //Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();


        Assert.assertTrue(hoverPlay().isDisplayed());


    }


    @Test
    public void CountSongsInPlaylist() {


        LoginPage loginPage = new LoginPage(driver);
        HomePage homePAge = new HomePage(driver);
        loginPage.login();

        //Chose a playlist by name
        choosePlaylistByName("TestPro Playlist");

        //DisplayAllSongs
        displayAllSongs();
        //Number of songs are  equal to number of songs displayed in the info section
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(songCount())));
        // above is checking if string 1 is equal to string 2

    }

    @Test
    public void renamePlaylist() {
// Im having the same problems here to delete the old name all its doing is adding on to the name

        String updatedPlaylistMsg = "Updated playlist \" Test Edited Playlist.\"";

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();


        doubleClickPlaylist();

        enterNewName();

        Assert.assertEquals(getRenamePlaylistSuccessMgs(), updatedPlaylistMsg);


    }

    /// HERE Im still trying to delete the old playlist with the control backspace but its not working
    public void enterNewName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMgs() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();


    }

    public void doubleClickPlaylist() {

        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();
    }

    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    // helper method

    public int songCount() {

        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();

    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements
                (By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found:" + songCount());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }

    }

    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();

    }

    public WebElement hoverPlay() {

        WebElement playBtn = driver.findElement
                (By.cssSelector("[data-testid= 'play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
}
