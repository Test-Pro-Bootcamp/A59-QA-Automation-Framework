import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaySongsPage;

public class PlaySongTests extends BaseTest {

    @Test
    public void playSongs() throws InterruptedException {

        playSongBtn();
        Thread.sleep(5000);
        playNextSongBtn();
        findSoundBars();
    }

    public void playNextSongBtn() throws InterruptedException {

        PlaySongsPage playSongsPage = new PlaySongsPage(driver);
        playSongsPage.selectPlayNextSongBtn();
    }

    public void playSongBtn() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        PlaySongsPage playSongsPage = new PlaySongsPage(driver);

        loginPage.login();
        playSongsPage.selectPlaySongBtn();

    }

    public void findSoundBars() throws InterruptedException {

        PlaySongsPage playSongsPage = new PlaySongsPage(driver);
        Assert.assertTrue(playSongsPage.selectSoundBars().isDisplayed());

    }

    public String verifyDeleteNotificationMessage() {

        WebElement verifyDeleteNotification = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("div.success.show")));

        return verifyDeleteNotification.getText();

    }
}
