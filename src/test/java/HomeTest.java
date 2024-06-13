import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{
    String newPlaylistName = "Sample Edited Playlist";
    @Test
    public void hoverOverPlayButtonAndPlaySong () {

     enterEmail("kristina.sarkisyan@testpro.io");
     enterPassword("o8URUDnW");
     submit();
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    public WebElement hoverPlay() {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
@Test
    public void countSongsInPlaylist() {
    enterEmail("kristina.sarkisyan@testpro.io");
    enterPassword("o8URUDnW");
    submit();
    choosePlaylistByName("Candy");
    displayAllSongs();
    Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(songsCount())));
    
}

    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public int songsCount () {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found:  "+songsCount());
        for (WebElement e: songList) {
            System.out.println(e.getText());
        }
    }


    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }
@Test
public void renamePlaylist() {
String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
    enterEmail("kristina.sarkisyan@testpro.io");
    enterPassword("o8URUDnW");
    submit();
    doubleClickPlaylist();
    enterNewName();
    Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
}
public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();
}
public void doubleClickPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();
        }
public void enterNewName() {
    WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
    playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE);
    playlistInputField.sendKeys(newPlaylistName);
    playlistInputField.sendKeys(Keys.ENTER);
}


}
