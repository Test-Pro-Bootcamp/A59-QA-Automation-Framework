import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
//import pageFactory.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() {

//      GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

//      WHEN   // Example of Fluent
        loginPage.login();
//        loginPage.provideEmail("demo@testpro.io")
//                 .providePassword("te$t$tudent")
//                 .clickSubmit();

//      THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";

        // Steps
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); // https://qa.koel.app/
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void loginValidEmailEmptyPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.clickSubmit();
        // Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        String expectedUrl = "https://qa.koel.app/";

        loginPage.provideEmail(email);
        loginPage.provideEmail(password);
        loginPage.clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }
}