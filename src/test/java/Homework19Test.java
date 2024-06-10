import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
deleteExistingPlaylist();
clickOkAtPopupWindow();
Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMessage);

    }
    public String getDeletedPlaylistMsg() {
        WebElement notificationDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationDeleted.getText();
    }
    public void clickOkAtPopupWindow() {
        WebElement clickOkAtPopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dialog']//button[@class='ok']")));
        clickOkAtPopup.click();
    }

    public void clickExistingPlaylist() {
        WebElement clickExistingPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
        clickExistingPlaylist.click();
    }

    public void deleteExistingPlaylist() {
        WebElement clickDeleteExistingPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']/i[@class='fa fa-times']")));
        clickDeleteExistingPlaylist.click();

    }


}
