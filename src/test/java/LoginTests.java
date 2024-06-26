
    import org.testng.annotations.Test;
    import pgFactoryPages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!"); // Calling the login method from LoginPage
    }
}
