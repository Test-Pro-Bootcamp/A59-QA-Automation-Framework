import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

//Homework 21
public class RenamePlayList extends BaseTest {

    @Test
public void renamePlayListHw() {
        String currentPlayList = "Test Playlist for HW21";
        String newPlayList = "Playlist for hw";
        String updPlayListMsg = "Updated playlist \"Playlist for hw.\"";

        loginPage.login();
        homePage.chooseMyPlayList(currentPlayList);
        homePage.enterNamePlayList(newPlayList);
        Assert.assertTrue(homePage.getSuccessPlayListMessagePopup(updPlayListMsg).isDisplayed());
    }

}
