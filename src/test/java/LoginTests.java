import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("demo@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Thread.sleep(1000);
        // Add assertions for valid login
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Thread.sleep(1000);
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("demo@testpro.io");
        loginPage.clickSubmit();
        Thread.sleep(1000);
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }

    public void negativeLoginTest(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }
}