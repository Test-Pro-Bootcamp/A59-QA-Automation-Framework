import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {

        String expectedDeletedPlaylist = "Deleted playlist \"aa.\"";
        // Navigate to page

        navigateToPage();
        //login
        enterEmail("apurva.singh@testpro.io");
        enterPassword("te$tpro$tudent1");
        submit();

        //choose playlist
        choosePlaylist();

        //delete selected playlist
        deleteSelectedPlaylist();

        //Assert (actual vs expected
        Assert.assertEquals(getDeletePlaylistSuccessMsg(), expectedDeletedPlaylist);

    }

    private String getDeletePlaylistSuccessMsg() throws InterruptedException {

        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String message = notification.getText();
        return message;
    }

    public void deleteSelectedPlaylist() {
        // WebElement deletePlaylistBtn = driver.findElement(By.xpath("//*[@title='Delete this playlist']"));
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Delete this playlist']")));
        deletePlaylistBtn.click();
    }

    public void choosePlaylist() {
        //WebElement playlistToDelete = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/nav/section[2]/ul/li[4]"));
        WebElement playlistToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/nav/section[2]/ul/li[4]")));
        playlistToDelete.click();
    }


}