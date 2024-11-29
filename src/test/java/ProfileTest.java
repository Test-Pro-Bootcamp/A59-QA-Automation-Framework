import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.ProfilePage;

    public class ProfileTest extends BaseTest{
        @Test
        public void changeCurrentTheme() throws InterruptedException {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            ProfilePage profilePage = new ProfilePage(getDriver());

            loginPage.provideEmail("kristina.sarkisyan@testpro.io")
                    .providePassword("o8URUDnW")
                    .clickSubmit();

            homePage.clickProfileIcon();

            profilePage.chooseVioletTheme();

            Assert.assertTrue(profilePage.isVioletThemeSelected());
        }
    }

