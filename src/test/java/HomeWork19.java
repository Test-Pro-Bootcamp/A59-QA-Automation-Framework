import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {


    @Test

   public void deletePlaylist() {
      // navigateToPage();

        String expectedDeletedPlaylist = "Deleted playlist \"some playlist.\"";
       enterEmail();
       enterPassword();
       submit();
       choosePlaylist();
       deleteSelectedPlaylist();
        Assert.assertEquals(getDeletePlaylistSuccessMsg(), expectedDeletedPlaylist);

    }

    public void deleteSelectedPlaylist() {
        WebElement deletePlaytlistBtn = driver.findElement(By.xpath
                ("//*[@title='Delete this playlist']"));
        deletePlaytlistBtn.click();

    }

    public void choosePlaylist(){
        WebElement playlistToDelete = driver.findElement(By.xpath
                ("//*[@id='playlists']/ul/li[6]/a"));
        playlistToDelete.click();
    }


    public String getDeletePlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
