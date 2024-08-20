import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class KoelAppLoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    AllSongsPage allSongsPage = new AllSongsPage(getDriver());
    ProfilePage profilePage = new ProfilePage(getDriver());

    //After registration in the Koel App, Login and navigate to Home Page
    @Test
    public void loginValidEmailPassword(){
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    // Staying in Home Page able navigate to AllSongs Page
    @Test
    public void toAllSongs(){
        loginPage.login();
        homePage.chooseAllSongsList();
        Assert.assertTrue(allSongsPage.getToAllSongsPage().isDisplayed());
    }
    //After logging out and logging in should be taken to a last visited page(AllSongs)
    @Test
    public void backToAllSongs(){
        loginPage.login();
        allSongsPage.getToAllSongsPage();
        Assert.assertTrue(allSongsPage.getToAllSongsPage().isDisplayed());
    }
    @Test
    public void getNewEmailPassword(){
        String newPassword = "Ilya!461";
        String newEmail = "11111hek@gmail.com";
        String password = "ak1234!@#$";
        loginPage.login();
        profilePage.getNavigateToProfilePage();
        profilePage.updateEmailPassword(newEmail,newPassword);
        profilePage.getCurrentPassword(password);
        Assert.assertTrue(profilePage.getProfileEmail().isDisplayed());
    }
    @Test(dataProvider = "NegativeLoginTestData" , dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(getDriver().getCurrentUrl(),expectedUrl);
    }


}
