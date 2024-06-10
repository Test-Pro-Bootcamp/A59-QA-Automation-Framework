import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewPlaylistTest extends BaseTest {
   @Test
    public void createNewPlaylists() {

        String expectedCreatedPlaylistMessage = "Created playlist \"Kristina.\"";
        enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();
        clickPlaylists();
        clickNewPlaylist();
        inputNewPlaylistName();
        Assert.assertEquals(getCreatedPlaylistMessage(),expectedCreatedPlaylistMessage);

    }
    public void clickPlaylists() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']")));
        clickPlaylist.click();
    }

    public void clickNewPlaylist() {
        WebElement clickNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]")));
        clickNewPlaylistBtn.click();
    }

    public void inputNewPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/form/input")));
        newPlaylistName.sendKeys("Kristina");
        newPlaylistName.sendKeys(Keys.ENTER);
    }
    public String getCreatedPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }


}
