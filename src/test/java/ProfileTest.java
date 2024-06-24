import page.HomePage;
import page.LoginPage;

public class ProfileTest extends BaseTest{

    public void changeCurrentTheme() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("kristina.sarkisyan@testpro.io");
    }
}
