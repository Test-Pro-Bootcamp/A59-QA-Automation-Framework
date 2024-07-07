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

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    AllSongsPage allSongsPage = new AllSongsPage(driver);


        //login
        loginPage.provideEmail("aleksei.koksharov@testpro.io");
        loginPage.providePassword("ak1234!@#$");
        loginPage.clickSubmit();

        //Navigate to AllSongs Page
        homePage.chooseAllSongsList();
        //ContextClick on the first song
        allSongsPage.contextClickFirstSong();
        //Choose Play from context menu
        allSongsPage.choosePlayOption();
        //Verify if Song being played.
        Assert.assertTrue(allSongsPage.isSongPlaying());


    }

    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public void contextClickFirstSong() {
       WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated
               (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
       actions.contextClick(firstSongElement).perform();
    }

    public void navigateToChooseAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li a.songs"))).click();

    }

    public boolean isSongPlaying(){
        WebElement songBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid = 'sound-bar-play']")));
        return songBarVisualizer.isDisplayed();

    }

}
