import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest {

    private LoginPage loginPage;
    private PlaylistPage playlistPage;

    @BeforeMethod
    @Override
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) {
        super.launchBrowser(baseURL);
        loginPage = new LoginPage(driver);
        playlistPage = new PlaylistPage(driver);
    }

    @Test
    public void renamePlaylist() {
        // Login
        loginPage.login(email, password);

        // Create a Playlist
        playlistPage.createPlaylist("MyNewList");

        // Rename the Playlist
        playlistPage.renamePlaylist("RenamedList");

        // Assert Success Popup is Displayed
        Assert.assertTrue(playlistPage.getSuccessPopup().isDisplayed());

        // Quitting the WebDriver session
        driver.quit();
    }
}