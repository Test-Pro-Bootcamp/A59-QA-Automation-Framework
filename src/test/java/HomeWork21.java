import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest{

    @Test
    public void renamePlaylist(){
        String RenamedPlaylistMsg = "Updated playlist \"RenamedPlaylist.\"";

        enterEmail(email);
        enterPassword(password);
        submit();
        doubleClickPlaylist();
        enterPlaylistNewName();
        Assert.assertEquals(getRenamedPlaylistSuccessMsg(), RenamedPlaylistMsg);
    }


    public void doubleClickPlaylist() {

       WebElement playlistToRename = wait.until
               (ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[4]/a")));
       actions.doubleClick(playlistToRename).perform();
    }
    public void enterPlaylistNewName() {
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistNameField.sendKeys("RenamedPlaylist");
        playlistNameField.sendKeys(Keys.ENTER);
    }

    public String getRenamedPlaylistSuccessMsg(){
        WebElement PlaylistNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return PlaylistNotification.getText();
    }
}
