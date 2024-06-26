/*import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test

    public void loginValidEmailPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //@Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        // Steps
        enterEmail("invalid@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); // https://qa.koel.app/
    }

    // @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        enterEmail("invalid@testpro.io");
        submit();
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    //@Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }


    provideEmail();
    providePassword();
    clickSubmit();


}
*/
    import org.testng.annotations.Test;
    import pgFactoryPages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!"); // Calling the login method from LoginPage
    }
}
