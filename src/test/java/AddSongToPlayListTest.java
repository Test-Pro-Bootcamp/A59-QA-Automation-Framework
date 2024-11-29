import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

//Homework 17
public class AddSongToPlayListTest extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String songName = "dark";
        loginPage.login();
        homePage.enterSearchSong(songName);
        homePage.clickViewAllBtn();
        homePage.selectFirstSong();
        homePage.clickAddToBtn();
        homePage.choosePlayList();
        Assert.assertTrue(homePage.getAddToPlayListMessage().isDisplayed());
    }
}
