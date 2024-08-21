import io.cucumber.java.nl.Stel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test(enabled = false)
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

    @Test(enabled = true)
    public void loginInvalidEmailValidPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = true)
    public void loginValidEmailInvalidPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("demo@testpro.io");
        loginPage.providePassword("InvalidPa$$wd");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }


    @Test(enabled = false)
    public void loginInvalidEmailEmptyPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = true)
    public void loginInvalidEmailFormatNoAtSymbolValidPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("invalidtestpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = true)
    public void loginInvalidEmailFormatNoAtSymbolEmptyPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("invalidtestpro.io");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = true)
    public void loginInvalidEmailFormatNoPeriodSymbolValidPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("invalid@testproio");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = true)
    public void loginInvalidEmailFormatNoDomainSymbolValidPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("invalid@testpro");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = false)
    public void loginInvalidEmailFormatNoPeriodEmptyPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("invalid@testproio");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = false)
    public void loginInvalidEmailFormatNoAtNoPeriodEmptyPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("invalidtestproio");
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = false)
    public void loginEmptyEmailEmptyPassword() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(enabled = false)
    public void loginValidEmailInvalidPasswordShowMsg() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail("demo@testpro.io");
        loginPage.providePassword("InvalidPa$$wd");
        loginPage.clickSubmit();

//      THEN
        Assert.assertTrue(loginPage.isDisplayedValidationMsg());
    }

    @Test(enabled = false)
    public void loginEmptyEmailEmptyPasswordShowMsg() {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.clickSubmit();

//      THEN
        Assert.assertTrue(loginPage.isDisplayedValidationMsg());
    }


    @Test(enabled = false, dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {

//      GIVEN
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());

//      WHEN
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();

//      THEN
        Assert.assertEquals(loginPage.selectCurrentPage(), expectedUrl);
    }

    @Test(enabled = true)
    public void loginAndGoToHomePage() {

//      GIVEN
        String expectedURL = "https://qa.koel.app/#!/home";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

//      WHEN
        loginPage.login();
        homePage.selectHomePage();

//      THEN
        Assert.assertEquals(loginPage.selectCurrentPage(), expectedURL);
    }

    @Test(enabled = true)
    public void loginGoToHomePageGoToFavoritesPageThenLogOutAndLogBackInToLastPageVisited() {
        // Test to see if the last page visited is the same page you go to after login

//      GIVEN
        String expectedURL = "https://qa.koel.app/#!/favorites";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

//      WHEN
        loginPage.login();
        homePage.selectHomePage();
        homePage.selectFavoriesPage();
        loginPage.logOut();
        loginPage.login();

//      THEN
        Assert.assertEquals(loginPage.selectCurrentPage(), expectedURL);
    }
}