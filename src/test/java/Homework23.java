import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class Homework23 extends BaseTest{

    @Test
    public void loginValidEmailPwdUsingPageFactoryPages() {
        // Instantiate needed objects
        LoginPage loginPage = new LoginPage(driver);
        // Step 1 - Login
        loginPage.provideEmail("leon.poyau+2@testpro.io");
        loginPage.providePassword("N6wWY2Rx");
        submit();

        // Validate & verify that login is success via assertion
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
}
