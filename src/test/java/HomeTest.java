import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlayListPage;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class HomeTest extends BaseTest {

    String newPlayListName = "Sample Edited Playlist";

    @Test
    public void HoverOverPlayBtnAndPlaySong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Thread.sleep(5000);
        hoverPlay();
    //  doubleClickPlayList();
    //  Thread.sleep(2000);
    //  Assert.assertTrue(hoverPlay().isDisplayed());
    }

    @Test
    public void countSongsInPlayList() throws InterruptedException {

        //Choose a Playlist by Name
        choosePlayListByName("TestPro Playlist");
        //DisplayAllSongs
        displayAllSongs();
        //Number of Songs are equal to number of songs displayed in the info section
        Thread.sleep(2000);
        Assert.assertTrue(getPlayListDetails().contains(String.valueOf(songsCount())));
    }

    @Test
    public void renamePlayList() throws InterruptedException {

        String updatedPlayListMsg = "Updated playlist \"Sample Edited Playlist.\"";

    //  double click on playList Name
    //  Thread.sleep(2000);
        hoverPlay();
    //  doubleClickPlayList();
    //  Thread.sleep(2000);
    //  Enter new Name
    //  enterNewName();
    //  Thread.sleep(2000);
    //  Assert.assertEquals(getRenamePlayListSuccessMsg(), updatedPlayListMsg);
    }

    //  Helper Methods

    public String getRenamePlayListSuccessMsg() {
        WebElement notification = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));

        return notification.getText();
    }

    public void enterNewName() {
        WebElement playListInputField = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("[name='name']")));
    //  playListInputField.clear(); Does not work here
    //  Use Send Control-A sequence then a Back Space sequence
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"A"), Keys.BACK_SPACE);
        playListInputField.sendKeys(newPlayListName);
        playListInputField.sendKeys(Keys.ENTER);

    }

    public void doubleClickPlayList() throws InterruptedException {
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".playlist:nth-child(3)")));
        actions.moveToElement(playList).perform();
        actions.doubleClick(playList).perform();
    }

    public String getPlayListDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public int songsCount() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements
                (By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found:  " + songsCount());
        for (WebElement e: songList) {
            System.out.println(e.getText());
        }
    }

    public void choosePlayListByName(String playListName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(text(), '"+ playListName +"')]")));
    }

    public WebElement hoverPlay() {
        WebElement playBtn = driver.findElement
                (By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        actions.click(playBtn).perform();

        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("[data-testid = 'sound-bar-play")));

        return soundBarVisualizer.isDisplayed();
    }
}
