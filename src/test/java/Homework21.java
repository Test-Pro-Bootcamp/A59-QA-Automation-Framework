import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {

    String UpdatedName = "Good Morning";

    @Test
    public void newPlaylistName(){

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();

        String updatedPlaylistMsg = "Updated playlist \" Good Morning.\"";
        doubleClickPlaylist();
        newNamePlaylist();
        Assert.assertEquals(successMessage(),updatedPlaylistMsg);
    }
// in this area I'm unable to Back_space all of it. for some reason its only doing one letter
    public void newNamePlaylist() {

        WebElement playlistFiled = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("[name='name']")));
        playlistFiled.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
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
