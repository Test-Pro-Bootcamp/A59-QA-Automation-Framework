import org.testng.Assert;
import org.testng.annotations.Test;

public class KoelAppLoginTest extends BaseTest {


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
        Assert.assertTrue(allSongsPage.getToAllSongsCount().isDisplayed());
    }
    //After logging out and logging in should be taken to a last visited page(AllSongs)
    @Test
    public void backToAllSongs(){
        loginPage.login();
        allSongsPage.getToAllSongsCount();
        Assert.assertTrue(allSongsPage.getToAllSongsCount().isDisplayed());
    }
    //Update Email
    @Test
    public void getNewEmail(){
        String newEmail = "11111hek@gmail.com";
        loginPage.login();
        profilePage.getNavigateToProfilePage();
        profilePage.updateEmail(newEmail);
        Assert.assertTrue(profilePage.getProfileEmail().isDisplayed());
    }
    //Update Password
    @Test
    public void getNewPassword(){
        String newPassword = "Ilya!461";
        loginPage.login();
        profilePage.getNavigateToProfilePage();
        profilePage.updatePassword(newPassword);
        Assert.assertTrue(profilePage.getProfilePassword().isDisplayed());
    }
    //Negative result Login
    @Test(dataProvider = "NegativeLoginTestData" , dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(getDriver().getCurrentUrl(),expectedUrl);
    }


}
