//import pages.LoginPage;
//import pages.PlaylistActions;
//import org.testng.annotations.Test;
import pgFactoryPages.LoginPage;
import pgFactoryPages.PlaylistActions;
import org.testng.annotations.Test;

public class PlaylistActionsTest extends BaseTest {

    @Test
    public void deletePlaylist() {
        // Instantiate LoginPage and PlaylistActions
        LoginPage loginPage = new LoginPage(driver);
        PlaylistActions playlist = new PlaylistActions(driver);

        // Perform login
        //loginPage.login();
        loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!");
        // Perform login
       // loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!");


        // Perform delete playlist action

        playlist.selectPlayList();
        playlist.deletePlaylist();
        playlist.successPopUpBox();
       // playlist.confirmDeleteBox();
    }
}