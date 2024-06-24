import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class Homework22Test extends BaseTest {

    @Test
    public void renamePlaylist() throws InterruptedException {
        String newPlaylistName = "Kristina";
        String updatedPlaylistMsg = "Updated Playlist \"Kristina.\"";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }
}
