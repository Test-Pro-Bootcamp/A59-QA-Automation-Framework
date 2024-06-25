import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.HomePage;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {

//      GIVEN
        String uniqueName;
        String expectedUpdatedMsg = "Profile updated.";
        String test = "";

        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        Thread.sleep(2000);

//      WHEN
        profilePage.selectProfileNameBtn();
        uniqueName = profilePage.generateUniqueName();
        profilePage.selectInputProfileNameField(uniqueName);
        profilePage.selectInputProfilePasswordField(userPassword);

//      THEN
        Assert.assertEquals(profilePage.selectUpdatedVerifyNotificationMsg(test), expectedUpdatedMsg);
    }

    @Test
    public void changeCurrentTheme() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();

        homePage.clickProfileIcon();

        profilePage.chooseVioletTheme();

        Assert.assertTrue(profilePage.isVioletThemeSelected());

    }

}
