import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.HomePage;

import static org.bouncycastle.cms.RecipientId.password;

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
        profilePage.selectInputProfileCurrentPasswordField(userPassword);

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
        String newUserEmail = "james.mar-new@testpro.io";
        String expectedUpdatedMsg = "Profile updated.";
        String test = "";

        loginPage.login();

//      WHEN
        // Change email
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(newUserEmail);
        profilePage.selectInputProfileCurrentPasswordField(userPassword);

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
        profilePage.selectInputProfileCurrentPasswordField(userPassword);

//      THEN
        Assert.assertEquals(profilePage.selectVerifyNotificationMsg(), expectedUpdatedMsg);
    }

    @Test (enabled = true)
    public void changeCurrentEmailAndPasswordAndLogoutTest()  {

//      GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        String newUserEmail = "james.mar-new@testpro.io";
        String newUserPassword = "te$t$tudent2";
        String expectedUpdatedMsg = "Profile updated.";
        String test = "";

        loginPage.login();

//      WHEN
        // Change current email and password
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(newUserEmail);
        profilePage.selectInputProfileNewPasswordField(newUserPassword);
        profilePage.selectInputProfileCurrentPasswordField(userPassword);

//        Thread.sleep(3000);
//        // logout
//        loginPage.logOut();
//        Thread.sleep(9000);
//
//        loginPage.provideEmail(newUserEmail);
//        loginPage.providePassword(newUserPassword);
//        loginPage.clickSubmit();
//
//        // try to log back in with old email and password
//        driver.navigate().refresh();
//        loginPage.provideEmail(userEmail);
//        loginPage.providePassword(userPassword);
//        loginPage.clickSubmit();
//
//        // log back in with new email and password
//        driver.navigate().refresh();
//        loginPage.provideEmail(newUserEmail);
//        loginPage.providePassword(newUserPassword);
//        loginPage.clickSubmit();

        // change the email back to the original
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(userEmail);
        profilePage.selectInputProfileNewPasswordField(userPassword);
        profilePage.selectInputProfileCurrentPasswordField(newUserPassword);
        loginPage.logOut();

//      THEN
        Assert.assertTrue(loginPage.isDisplayedLoginAvatar());
    }
}
