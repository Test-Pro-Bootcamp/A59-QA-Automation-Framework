
/*import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homeWork18 extends BaseTest{


    @Test
    public void playSong(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.provideEmail("demo@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();;
        homePage.chooseAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();

        allSongsPage.validateSongPlaying();
    }
} */