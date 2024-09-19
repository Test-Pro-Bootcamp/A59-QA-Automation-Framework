import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateEmailTest extends BaseTest{

    //Update Email
    @Test
    public void newEmail(){
        String newEmail = "11111hek@gmail.com";
        loginPage.login();
        profilePage.getNavigateToProfilePage();
        profilePage.updateEmail(newEmail);
        Assert.assertTrue(profilePage.getProfileEmail().isDisplayed());
    }
    //Negative testing("Error Message" pop up, but the Locator for that message was not found)
    @Test(dataProvider = "emailRegistrationCredentials" , dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email) {
        profilePage.updateEmail(email);
        Assert.assertFalse(profilePage.getSuccessMsg().isDisplayed()); //success message not pop up
    }
    //Login with updated Email(11111hek@gmail.com)
    @Test
    public void loginWithUpdatedEmail(){
        loginPage.newLoginEmail();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    //Not able to Login with old email
    @Test
    public void oldLogin(){
        String expectedUrl = "https://qa.koel.app/";
        loginPage.login();
        Assert.assertEquals(getDriver().getCurrentUrl(),expectedUrl);
    }


}
