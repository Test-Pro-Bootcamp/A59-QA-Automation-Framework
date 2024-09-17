import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlayListPage;

//Homework 19
public class DeletePlayList extends BaseTest {

    @Test

    public void deletePlayList() {
        String playListName = "Playlist 78";
        loginPage.login();
        homePage.createPlayList(playListName);
        homePage.openPlayList(playListName);
        playListPage.deletePlayList();
        Assert.assertTrue(homePage.getPlayListByName(playListName).isDisplayed());

    }

}
