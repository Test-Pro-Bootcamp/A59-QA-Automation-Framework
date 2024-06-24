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
        enterEmail("invalid@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); // https://qa.koel.app/
    }

   // @Test
    public void loginValidEmailEmptyPassword() {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        enterEmail("invalid@testpro.io");
        submit();
        // Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    //@Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }

}