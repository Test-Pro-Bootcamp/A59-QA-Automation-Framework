import Pages.HomePage;
import Pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);
    // @Test

    @Test
        public void validLogin() {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);


            loginPage.login(email, password);
            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        }

        @Test
        public void loginValidEmailInvalidPasswordTest() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginValidEmailInvalidPassword();
            String url = "https://qa.koel.app/";
            Assert.assertEquals(driver.getCurrentUrl(), url);

        }

        @Test
        public void loginInvalidEmailValidPasswordTest() {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginInvalidEmailValidPassword();
            String url = "https://qa.koel.app/";
            Assert.assertEquals(driver.getCurrentUrl(), url);
        }

    @Test
    public void loginEmptyEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);


        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}