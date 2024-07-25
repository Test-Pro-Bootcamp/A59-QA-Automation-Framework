import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.HomePage;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName() {

//      GIVEN
        String uniqueName;
        String expectedUpdatedMsg = "Profile updated.";
        String test = "";

        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.login();

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

//      GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.login();

//      WHEN
        homePage.clickProfileIcon();
        profilePage.selectVioletTheme();

//        System.out.println("Current Theme: " + profilePage.selectCurrentTheme());

//      THEN
        Assert.assertTrue(profilePage.isVioletThemeSelected());

    }
}
