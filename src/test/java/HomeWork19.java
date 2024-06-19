import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {


    @Test

   public void deletePlaylist() {
      // navigateToPage();

        String expectedDeletedPlaylist = "Deleted playlist \"some playlist.\"";
       enterEmail(email);
       enterPassword(password);
       submit();
       choosePlaylist();
       deleteSelectedPlaylist();
        Assert.assertEquals(getDeletePlaylistSuccessMsg(), expectedDeletedPlaylist);

    }

    public void deleteSelectedPlaylist() {
        WebElement deletePlaytlistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@title='Delete this playlist']")));
        deletePlaytlistBtn.click();

    }

    public void choosePlaylist(){
        WebElement playlistToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='playlists']/ul/li[6]/a")));
        playlistToDelete.click();
    }


    public String getDeletePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
