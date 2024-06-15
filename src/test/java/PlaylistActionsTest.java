import pages.LoginPage;
import pages.PlaylistActions;
import org.testng.annotations.Test;

public class PlaylistActionsTest extends BaseTest {

    @Test
    public void deletePlaylist() {
        // Instantiate LoginPage and PlaylistActions
        LoginPage loginPage = new LoginPage(driver);
        PlaylistActions playlist = new PlaylistActions(driver);

        // Perform login
        loginPage.login();

        // Perform delete playlist action
        playlist.selectPlayList();
        playlist.deletePlaylist();
        playlist.successPopUpBox();
       // playlist.confirmDeleteBox();
    }
}