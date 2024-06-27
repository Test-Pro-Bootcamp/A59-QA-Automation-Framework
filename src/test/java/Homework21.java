import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String UpdatedName = "Good Morning";

    @Test
    public void newPlaylistName() throws InterruptedException {

        String updatedPlaylistMsg = "Updated playlist \" Good Morning.\"";
        //login

        enterEmail("christina.taylor@testpro.io");
        enterPassword("jKV0uSX6z1dv");
        submit();

        // Double click method
        doubleClickPlaylist();

        // rename playlist
        newNamePlaylist();

        //Assert

        Assert.assertEquals(getRenamePlaylistSuccessMgs(),updatedPlaylistMsg);
    }
// in this area I'm unable to Back_space all of it. for some reason its only doing one letter
    public void newNamePlaylist() {

        WebElement newName = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("[name='name']")));
        newName.sendKeys(Keys.chord(Keys.CONTROL,"A"), Keys.BACK_SPACE);
        newName.sendKeys(UpdatedName);
        newName.sendKeys(Keys.ENTER);
    }



    public String getRenamePlaylistSuccessMgs() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();

    }
    public void doubleClickPlaylist() {

        WebElement playlistLazyDays = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".playlist:nth-child(4)")));
        actions.doubleClick(playlistLazyDays).perform();


    }

}
