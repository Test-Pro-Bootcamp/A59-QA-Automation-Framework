
import pgFactoryPages.LoginPage;
import pgFactoryPages.PlaylistActions;
import org.testng.annotations.Test;

public class PlaylistActionsTest extends BaseTest {

    @Test
    public void deletePlaylist() {
        // Instantiate LoginPage and PlaylistActions
        LoginPage loginPage = new LoginPage(getDriver());
        PlaylistActions playlist = new PlaylistActions(getDriver());

        // Perform login
        loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!");

        // Perform delete playlist action
        playlist.selectPlayList();
        playlist.clearInfo();
        playlist.deletePlaylist();
        playlist.successPopUpBox();
    }
}