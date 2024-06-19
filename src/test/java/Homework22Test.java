import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class Homework22Test extends BaseTest {

    @Test
    public void renamePlaylist() throws InterruptedException {
        String newPlaylistName = "My new playlist";
        String updatedPlaylistMsg = "Updated Playlist \"My new playlist.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);

    }
}
