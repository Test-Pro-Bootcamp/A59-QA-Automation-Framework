import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class createPlaylistsTests extends BaseTest {
    @Test
    public void createPlaylist() throws InterruptedException {
        String expectedCreatedPlaylistMessage = "Created playlist \"Kristina.\"";
        enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();
        clickPlaylists();
        Thread.sleep(2000);
        clickNewPlaylist();
        Thread.sleep(2000);
        inputNewPlaylistName();
        Thread.sleep(2000);
        Assert.assertEquals(getCreatedPlaylistMessage(),expectedCreatedPlaylistMessage);


    }
    public String getCreatedPlaylistMessage() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void inputNewPlaylistName() {
        WebElement newPlaylistName = driver.findElement(By.xpath("//*[@id=\"playlists\"]/form/input"));
        newPlaylistName.sendKeys("Kristina");
        newPlaylistName.sendKeys(Keys.ENTER);
    }


    public void clickNewPlaylist() {
        WebElement clickNewPlaylistBtn = driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        clickNewPlaylistBtn.click();
    }

    public void clickPlaylists() {
        WebElement clickPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']"));
        clickPlaylist.click();
    }
}
