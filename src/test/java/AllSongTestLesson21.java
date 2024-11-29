import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongTestLesson21 extends BaseTest {

@Test
    public void playSongWithRightClick() {
        //login
        //Navigate to AllSongs Page
        loginPage.login();
        homePage.chooseAllSongsList();
        //ContextClick on the first song
        allSongsPage.contextClickFirstSong();
        //Choose Play from context menu
        allSongsPage.choosePlayOption();
        //Verify if Song being played.
        Assert.assertTrue(allSongsPage.isSongPlaying());


    }
}
