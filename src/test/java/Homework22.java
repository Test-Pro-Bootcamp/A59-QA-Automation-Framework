import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SongsPage;

public class Homework22 extends BaseTest {
    @Test
    public void loginValidEmailPwdUsingPages()  {
        // Create an instance of the LoginPage & HomePage class below
        // And use them instead of enterEmail() and enterPassword() from BaseTest class.

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Step 1 - Login into Koel app
        loginPage.login();
        // Validate and Verify that user logged successfully via assertion. Is the User Avatar Icon displayed on home page
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test(dataProvider="NegativeLoginTestData")
    public void negativeLoginTestUsingPages(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        String expectedURL = "https://qa.koel.app/";

        // Step -1 // Attempt to log into Koel app using negative data. Unhappy path.
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.submitClick();
        // Verify that login attempts have failed via assertion. Login page should still be available
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test
    public void changeProfileNameUsingPages() throws InterruptedException {
        // Create an instance of the LoginPage & HomePage class below
        // And use them instead of enterEmail() and enterPassword() from BaseTest class.

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Step 1 - Login into Koel app
        loginPage.login();
        // Validate and Verify that user logged successfully via assertion. Is the User Avatar Icon displayed on home page
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

        // Step 2 - Navigate User & profile name page
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.navigateToProfilePage();

        // Step 3 - Change profile name to new name
        String uniqueName = profilePage.generateUniqueName();
        profilePage.changeName(uniqueName);

        String profileName = profilePage.getProfileName();
        // Validate/verify that profile name was changed via assertion
        Assert.assertEquals(profileName, uniqueName);
    }

    @Test
    public void playSongWithRightClickUsingPage() {
        // Instantiate needed objects from the required Pages
        LoginPage loginPage = new LoginPage(driver);
        SongsPage songsPage = new SongsPage(driver);

        // Step 1 - Login into Koel application
        loginPage.login();

        // Step 2 - Navigate to All Songs Page
        songsPage.navigateToAllSongsPage();

        // Step 3 - Right/Context click on the first song
        songsPage.rightClickFirstSong();

        // Step 4 - Choose play option from the context menu
        songsPage.choosePlayOption();

        // Validate/verify that song is actually playing via assertion
        Assert.assertTrue(songsPage.isSongPlaying());
    }

    @Test
    public void renamePlayLisUsingPage() throws InterruptedException {
        String newPlaylistName = "Sample Edited Playlist";
        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

        // Create needed and appropriate page Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        // Step 1 - Login into Koel Application
        // Navigating to Koel login page is already done by @BeforeMethod in BaseTest class

        loginPage.provideEmail("leon.poyau+2@testpro.io");
        loginPage.providePassword("N6wWY2Rx");
        loginPage.submitClick();
        Thread.sleep(700); // needed because playlist elements aren't loaded until after at least 700ms or more
                                 // or use submit() from BaseTest class which has a 2s delay after it runs
                                 // This avoids the Timeout Exception that is otherwise thrown at Step 2 below.


        // Step 2 - Double-click on PlayList link to be renamed
        homePage.doubleClickPlayList();

        // Step 3 - Enter new name to rename the playlist
        homePage.enterNewName(newPlaylistName);

        // Validate/verify that playlist was renamed via assertion
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }
}
