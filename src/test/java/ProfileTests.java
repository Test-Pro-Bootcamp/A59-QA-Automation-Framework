import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.HomePage;

public class ProfileTests extends BaseTest{

    @Test (enabled = false)
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

    @Test (enabled = false)
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

    @Test (enabled = true)
    public void changeCurrentEmailAndTestIfOldOneStillWorks() {

//      GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        String newUserEmail = "mydemo@testpro.io";
        String expectedUpdatedMsg = "Profile updated.";
        String test = "";

        loginPage.login();

//      WHEN
        // Change email
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(newUserEmail);
        profilePage.selectInputProfilePasswordField(userPassword);

        // logout
        loginPage.logOut();

        // log back in with old email and password
        driver.navigate().refresh();
        loginPage.provideEmail(userEmail);
        loginPage.providePassword(userPassword);
        loginPage.clickSubmit();

        // log back in with new email and password
        driver.navigate().refresh();
        loginPage.provideEmail(newUserEmail);
        loginPage.providePassword(userPassword);
        loginPage.clickSubmit();

        // change the email back to the original
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(userEmail);
        profilePage.selectInputProfilePasswordField(userPassword);

//      THEN
        Assert.assertEquals(profilePage.selectVerifyNotificationMsg(), expectedUpdatedMsg);
    }
}
