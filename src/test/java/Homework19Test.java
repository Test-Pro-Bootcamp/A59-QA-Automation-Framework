import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19Test extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Kristina.\"";
enterEmail("kristina.sarkisyan@testpro.io");
enterPassword("o8URUDnW");
submit();
clickExistingPlaylist();
Thread.sleep(2000);
deleteExistingPlaylist();
Thread.sleep(2000);
clickOkAtPopupWindow();
Thread.sleep(2000);
Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMessage);
    }
    public String getDeletedPlaylistMsg() {
        WebElement notificationDeleted = driver.findElement(By.cssSelector("div.success.show"));
        return notificationDeleted.getText();
    }
    public void clickOkAtPopupWindow() {
        WebElement clickOkAtPopup = driver.findElement(By.xpath("//div[@class='dialog']//button[@class='ok']"));
        clickOkAtPopup.click();
    }

    public void clickExistingPlaylist() {
        WebElement clickExistingPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        clickExistingPlaylist.click();
    }

    public void deleteExistingPlaylist() {
        WebElement clickDeleteExistingPlaylist = driver.findElement(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']/i[@class='fa fa-times']"));
        clickDeleteExistingPlaylist.click();

    }


}
