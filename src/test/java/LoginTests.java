import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() {

//      GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

//      WHEN
        loginPage.login();

//        Example of Fluent
//        loginPage.provideEmail("demo@testpro.io")
//                 .providePassword("te$t$tudent")
//                 .clickSubmit();

//      THEN
        Assert.assertTrue(homePage.selectUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(driver);

//      WHEN
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test
    public void loginValidEmailEmptyPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(driver);

//      WHEN
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(driver);

//      WHEN
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(loginPage.selectCurrentPage(), expectedUrl);
    }
}