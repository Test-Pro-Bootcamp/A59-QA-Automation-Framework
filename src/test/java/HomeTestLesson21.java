import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTestLesson21 extends BaseTest {

    String newPlayListName = "Sample Edited Playlist";

    @Test
    public void HoverOverPlayButtonAndPlaySong() {

        //login
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
        Assert.assertTrue(hoverPlay().isDisplayed());

    }

    @Test
    public void countSongsInPlayList(){
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();

        //Choose Playlist by Name
        choosePlayListByName("testplaylist 22");

        //DisplayAllSongs
        displayAllSongs();
        //Number of songs equal to number of songs displayed in the into section.
        Assert.assertTrue(getPlayListDetails().contains(String.valueOf(songsCount())));
    }

    @Test
    public void renamePlaylist() throws InterruptedException {
        String updatedPlayListMsg = "Updated playlist \"Sample Edited Playlist.\"";
        //login
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
        Thread.sleep(2000);

        //double click on Playlist Name
        doubleClickPlayList();
        Thread.sleep(2000);
        //Enter New Name
        enterNewName();
        Thread.sleep(2000);
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlayListMsg);

    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void enterNewName(){
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlayListName);
        playListInputField.sendKeys(Keys.ENTER);

    }

public void doubleClickPlayList(){
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playList).perform();
}


    //Helper Methods

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

    public void choosePlayListByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }

    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }
}
