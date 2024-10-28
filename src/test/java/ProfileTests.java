import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        // Create an instance of the LoginPage & HomePage class below
        // And use them instead of enterEmail() and enterPassword() from BaseTest class.

        LoginPage loginPage = new LoginPage(getDriver());
        //LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(getDriver());
        //HomePage homePage = new HomePage(driver);

        // Step 1 - Login into Koel app
        loginPage.login();
        // Validate and Verify that user logged successfully via assertion. Is the User Avatar Icon displayed on home page
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

        // Step 2 - Navigate User & profile name page
        ProfilePage profilePage = new ProfilePage(getDriver());
        //ProfilePage profilePage = new ProfilePage(driver);
        profilePage.navigateToProfilePage();

        // Step 3 - Change profile name to new name
        String uniqueName = profilePage.generateUniqueName();
        profilePage.changeName(uniqueName);

        String profileName = profilePage.getProfileName();
        // Validate/verify that profile name was changed via assertion
        Assert.assertEquals(profileName, uniqueName);
    }
} // Ends ProfileTests Class
