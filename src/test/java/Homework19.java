import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
       String expectedPlaylistDeletedMessage = "Deleted playlist \"First user playlist.\"";
        login("india.messam@testpro.io", "slcTalgy");
       clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
    }
    public void openPlaylist(){
        WebElement playlist = driver.findElement(By.cssSelector("[href='#!/playlist/95613']  "));
        playlist.click();
    }
    public void clickDeletePlaylistBtn() throws InterruptedException{
        WebElement deletePlaylist = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        deletePlaylist.click();
        Thread.sleep(2000);

    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }
}
