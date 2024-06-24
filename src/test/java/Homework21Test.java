import page.HomePage;
import page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21Test extends BaseTest{
    String newPlaylistName = "My New Edited Playlist";
    @Test
    public void createNewPlaylists() {

        String expectedCreatedPlaylistMessage = "Created playlist \"Candy.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        /*enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();*/
        clickPlaylists();
        clickNewPlaylist();
        inputNewPlaylistName();
        Assert.assertEquals(getCreatedPlaylistMessage(),expectedCreatedPlaylistMessage);

    }
    public void clickPlaylists() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//i[@class='fa fa-plus-circle create']")));
        clickPlaylist.click();
    }

    public void clickNewPlaylist() {
        WebElement clickNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]")));
        clickNewPlaylistBtn.click();
    }

    public void inputNewPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/form/input")));
        newPlaylistName.sendKeys("Candy");
        newPlaylistName.sendKeys(Keys.ENTER);
    }
    public String getCreatedPlaylistMessage() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"My New Edited Playlist.\"";
        enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();
        doubleClickPlaylist();
        enterNewName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }
    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();
    }
    public void doubleClickPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();
    }
    public void enterNewName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE);
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

}
