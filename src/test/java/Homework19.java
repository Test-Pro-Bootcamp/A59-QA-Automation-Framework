import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    @Parameters({"BaseURL"})
    public void deletePlayList(String baseURL) throws InterruptedException {
        // navigate to login page for Koel app
        navigateToPage(baseURL);
        // Step 1 - Login
        enterEmail("leon.poyau@testpro.io");;
        enterPassword("jTRCkwNf");
        submit();

        // Step 2 - Click playlist you want to delete
        clickOnPlaylist();
        Thread.sleep(1000);

        // Step 3 - Click on Delete playlist button
        clickDelPlaylistBtn();
        Thread.sleep(1000);

        // Step 4 - Click on OK button on dialog box to confirm intent to delete
//        clickOkToDelete();
//        Thread.sleep(1000);

        // Validate and verify playlist deleted by assertion.
        String msg = "\"Deleted playlist {LeonPlayList2.}\"";
        WebElement mesgDelModal = driver.findElement(
                By.xpath("//div[contains(text(),\"Deleted playlist \\\"LeonPlayList2.\\\"\")]"));
        Assert.assertTrue(mesgDelModal.isDisplayed());
    }

    public void clickOkToDelete() {
        WebElement okBtn = driver.findElement(
                By.xpath("clickDelPlaylist"));
            okBtn.click();
    }

    public void clickDelPlaylistBtn() {
        WebElement playlistDelBtn = driver.findElement(
                By.xpath("//section[@id='playlistWrapper']//button[@class='del btn-delete-playlist']"));
            playlistDelBtn.click();
    }

    public void clickOnPlaylist() {
        WebElement playList = driver.findElement(
                By.xpath("//section[@id='playlists']//a[@href='#!/playlist/97100']"));
        playList.click();
    }
}
