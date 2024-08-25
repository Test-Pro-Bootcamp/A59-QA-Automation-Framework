import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
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

    @Test (enabled = true, priority = 5)
    public void changeCurrentEmailAndTestIfOldOneStillWorks() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        String newUserEmail = "james.mar-new@testpro.io";
        String expectedUpdatedMsg = "Profile updated.";
        String test = "";

        loginPage.login();
        Thread.sleep(2000);
//      WHEN
        // Change email
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(newUserEmail);
        profilePage.selectInputProfileCurrentPasswordField(userPassword);

        // logout
        loginPage.logOut();
        Thread.sleep(2000);
        // log back in with old email and password
        driver.navigate().refresh();
        loginPage.provideEmail(userEmail);
        loginPage.providePassword(userPassword);
        loginPage.clickSubmit();

        // log back in with new email and password
        driver.navigate().refresh();
        Thread.sleep(2000);
        loginPage.provideEmail(newUserEmail);
        loginPage.providePassword(userPassword);
        loginPage.clickSubmit();

        // change the email back to the original
//        driver.navigate().refresh();
        Thread.sleep(2000);
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(userEmail);
        profilePage.selectInputProfileCurrentPasswordField(userPassword);

//      THEN
        Assert.assertEquals(profilePage.selectVerifyNotificationMsg(), expectedUpdatedMsg);
    }

    @Test (enabled = true, priority = 5)
    public void changeCurrentEmailAndPasswordAndLogoutTest() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        String newUserEmail = "james.mar-new@testpro.io";
        String newUserPassword = "te$t$tudent2";
        String expectedUpdatedMsg = "Profile updated.";
        String test = "";

        loginPage.login();
        Thread.sleep(3000);

//      WHEN
        // Change current email and password
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(newUserEmail);
        profilePage.selectInputProfileNewPasswordField(newUserPassword);
        profilePage.selectInputProfileCurrentPasswordField(userPassword);
        homePage.isNotDisplayedSuccessMsg();
        Thread.sleep(3000);

//        loginPage.logOut();
//        Thread.sleep(3000);
//        loginPage.isDisplayedLoginAvatar();
//
//        loginPage.provideEmail(newUserEmail);
//        loginPage.providePassword(newUserPassword);
//        loginPage.clickSubmit();
//
        // try to log back in with old email and password
//        driver.navigate().refresh();
//        loginPage.provideEmail(userEmail);
//        loginPage.providePassword(userPassword);
//        loginPage.clickSubmit();
//        homePage.isNotDisplayedSuccessMsg();
//        Thread.sleep(2000);
        // log back in with new email and password
//        driver.navigate().refresh();
//        loginPage.provideEmail(newUserEmail);
//        loginPage.providePassword(newUserPassword);
//        loginPage.clickSubmit();
//        homePage.isNotDisplayedSuccessMsg();
//        Thread.sleep(2000);
        // change the email back to the original
        homePage.clickProfileIcon();
        profilePage.selectInputProfileEmailField(userEmail);
        profilePage.selectInputProfileNewPasswordField(userPassword);
        profilePage.selectInputProfileCurrentPasswordField(newUserPassword);
        homePage.isNotDisplayedSuccessMsg();
//        Thread.sleep(5000);
        driver.navigate().refresh();

        // logout
        loginPage.logOut();
//        Thread.sleep(3000);
//        driver.navigate().refresh();

//      THEN
        Assert.assertTrue(loginPage.isDisplayedLoginAvatar());
    }
}
