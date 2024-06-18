//import pages.HomePage;
//import pages.LoginPage;
import pageFactory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest {


    @Test
    public void loginEmptyEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //Happy Path - Login Test
@Test
    public void loginValidEmailPassword()  {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.provideEmail("kristina.sarkisyan@testpro.io").providePassword("o8URUDnW").clickSubmit();
    Assert.assertTrue(homePage.getUserAvatar().isDisplayed());


    }

        /*//navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    // Negative Test Case
    @Test
    public void loginWithInvalidEmailValidPassword()  {
        //navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        enterEmail("invalid@koel.io");
        enterPassword("te$t$tudent");
        submit();
        //Expected Results - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    //Negative Test Case 2
    @Test
    public void loginWithNoPassword()  {
        //navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        enterEmail("invalid@koel.io");
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


    }
    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest (String email, String password) {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);*/

    }



