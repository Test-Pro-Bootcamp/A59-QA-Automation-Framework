import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AllSongsTest extends BaseTest {

    @Test
    public void playSongWithRightClick() {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);

        // Login
        loginPage.login();

//      WHEN
        // Navigate to All Songs Page
        driver.navigate().refresh();
        homePage.chooseAllSongsList();

        // Right/Context Click on the first song
        allSongsPage.selectFirstSong();
        allSongsPage.rightClickOnSong();

        // Click on play button
        allSongsPage.selectPlayBtn();

//      THEN
        Assert.assertTrue(homePage.isSongPlaying());
    }

    //Methods

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until
                    (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("[data-testid = 'sound-bar-play")));

        return soundBarVisualizer.isDisplayed();
    }
}
