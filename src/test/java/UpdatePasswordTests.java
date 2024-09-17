import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class UpdatePasswordTests extends BaseTest{

    //After register in Koel app, Login, navigate to Profile page, update password
    @Test
    public void successUpdatePassword(){
            String newPassword = "Ilya!461";
            loginPage.login();
            profilePage.getNavigateToProfilePage();
            profilePage.updatePassword(newPassword);
            Assert.assertTrue(profilePage.getProfilePassword().isDisplayed());
        }
        // Negative testing Password with invalid credentials
    @Test(dataProvider = "incorrectCredentials" , dataProviderClass = TestDataProvider.class)
    public void negativePasswordTest(String invalidPassword){
        loginPage.login();
        profilePage.notValidPassword(invalidPassword);
        Assert.assertTrue(profilePage.getErrorMsg().isDisplayed());
    }
    //Verify Login with updated password
    @Test
    public void loginWithUpdPassword(){
        String newPassword = "Ilya!461";
        loginPage.newLogin(newPassword);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    //Verify can not Login with old Password
    @Test
    public void oldPassword(){
        loginPage.login();
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }

}
