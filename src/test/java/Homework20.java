import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlayListPage;


public class Homework20 extends BaseTest {



    @Test

    public void deletePlayList() {
// Without 'Thread.sleep(s)'

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        String playListName = "Playlist 78";
        loginPage.login();
        homePage.createPlayList(playListName);
        homePage.openPlayList(playListName);
        playListPage.deletePlayList();
        Assert.assertTrue(homePage.getPlayListByName(playListName).isDisplayed());

    }

}
