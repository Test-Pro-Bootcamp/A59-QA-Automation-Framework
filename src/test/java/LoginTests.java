import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
//import pageFactory.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

//      WHEN
        loginPage.login();

// Example of Fluent
//        loginPage.provideEmail("demo@testpro.io")
//                 .providePassword("te$t$tudent")
//                 .clickSubmit();

//      THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //@Test
    public void loginInvalidEmailValidPassword() {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Steps
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); // https://qa.koel.app/
    }

   // @Test
    public void loginValidEmailEmptyPassword() {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("invalid@testpro.io");
        loginPage.clickSubmit();
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    //@Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}