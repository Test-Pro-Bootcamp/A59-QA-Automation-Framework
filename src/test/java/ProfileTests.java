import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {

        navigateToProfilePage();
        String uniqueName = generateUniqueName();
        Thread.sleep(2000);
        changeName(uniqueName);
        Thread.sleep(2000);
    }

    private void login() throws InterruptedException {
        enterEmail(userName);
        enterPassword(userPassword);
        submit();
    }

    private WebElement getProfileName() {

        ProfilePage profilePage = new ProfilePage(driver);

        return profilePage.selectProfileSaveInfo();

    }

    private String generateUniqueName() {

        return UUID.randomUUID().toString().replace("-", "");
    }

    private void changeName(String newName) throws InterruptedException {

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.selectInputProfileNameField(newName);
        profilePage.selectInputProfilePasswordField(userPassword);

        Assert.assertEquals(profilePage.selectVerifyNotificationMsg(), expectedProfileUpdatedMessage);

    }

    private void saveChanges() {

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.selectProfileSaveBtn();

    }

    private void enterNewName(String newName) {

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.selectInputProfileNameField(newName);

    }

    private void enterCurrentPassword(String userPassword) {

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.selectInputProfilePasswordField(userPassword);

    }

    private void navigateToProfilePage() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login();
        Thread.sleep(5000);
        profilePage.selectProfileNameBtn();

    }
}
