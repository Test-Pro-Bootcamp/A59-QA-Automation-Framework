import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class UpdatePasswordTests extends BaseTest{

    @Test
    public void successUpdatePassword(){

        //After register in Koel app, Login, navigate to Profile page, update password
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

}
