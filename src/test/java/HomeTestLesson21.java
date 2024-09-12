import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTestLesson21 extends BaseTest {

    String playListName = "Sample Edited Playlist";
    String playListForTest = "testplaylist 22";
    @Test
    public void HoverOverPlayButtonAndPlaySong() {
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

//    public String getRenamePlaylistSuccessMsg(){
//        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.cssSelector("div.success.show")));
//        return notification.getText();
//    }
//
//    public void enterNewName(){
//        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.cssSelector("[name='name']")));
//        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
//        playListInputField.sendKeys(newPlayListName);
//        playListInputField.sendKeys(Keys.ENTER);
//
//    }

//public void doubleClickPlayList(){
//        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(6)")));
//        actions.doubleClick(playList).perform();
//}


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

//    public void choosePlayListByName(String playlistName) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
//    }

//    public WebElement hoverPlay(){
//        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
//        actions.moveToElement(playBtn).perform();
//        return wait.until(ExpectedConditions.visibilityOf(playBtn));
//    }
}
