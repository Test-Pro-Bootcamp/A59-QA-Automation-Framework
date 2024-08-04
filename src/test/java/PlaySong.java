import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaySongPage;

public class PlaySong extends BaseTest {

    @Test

    public void playSong() {


        //navigateToPage();
//        enterEmail("aleksei.koksharov@testpro.io");
//        enterPassword("ak1234!@#$");
//        submit();
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlaySongPage playSongPage = new PlaySongPage(getDriver());
        loginPage.login();
        playSongPage.playBtn();
        playSongPage.allSongs();
        Assert.assertTrue(playSongPage.getIsDisplayedSoundBar().isDisplayed());


//    private boolean isDisplayedSoundBar() {
//        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.cssSelector("img[alt='Sound bars']")));
//        return soundBar.isDisplayed();
//    }
//
//    private void enterAllSongs() {
//        WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.cssSelector("a[href='#!/songs']")));
//        allSongs.click();
//    }
//
//
//    public void clickPlayBtn() {
//            WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
//                    (By.cssSelector("span.play")));
//            Actions actions = new Actions(getDriver());
//            actions.click(playBtn).perform();
//
//        }

    }

}