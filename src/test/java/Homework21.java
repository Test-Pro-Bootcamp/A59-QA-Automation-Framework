import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import pageFactory.AllSongsPage;

public class Homework21 extends BaseTest {

    String UpdatedName = "Good Morning";

    @Test
    public void newPlaylistName() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage =new AllSongsPage(driver);

        loginPage.login();

        String updatedPlaylistMsg = " \"Updated playlist \"Good Morning.\"";

        doubleClickPlaylist();
        homePage.reNamePlaylist(UpdatedName);
        Assert.assertEquals(homePage,updatedPlaylistMsg);
    }

    public void reNamePlaylist() {

        WebElement playlistFiled = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("[name='name']")));
        playlistFiled.sendKeys(Keys.chord(Keys.CONTROL, "A",Keys.BACK_SPACE));
        playlistFiled.sendKeys(UpdatedName);
        playlistFiled.sendKeys(Keys.ENTER);
    }


    public String successMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();


    }

    public void doubleClickPlaylist() {

        WebElement playlistLazyDays = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".playlist:nth-child(4)")));
        actions.doubleClick(playlistLazyDays).perform();

    }
}
