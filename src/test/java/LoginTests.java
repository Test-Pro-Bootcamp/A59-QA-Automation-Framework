import pageFactory.LoginPageFromFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class LoginTests extends BaseTest {


    @Test
    public void loginEmptyEmailPassword() {
        LoginPageFromFactory loginPageFromFactory = new LoginPageFromFactory(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPageFromFactory.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginValidEmailPassword() {
        LoginPageFromFactory loginPageFromFactory = new LoginPageFromFactory(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPageFromFactory.provideEmail("kristina.sarkisyan@testpro.io").providePassword("o8URUDnW").clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginWithInvalidEmailValidPassword() {
        String expectedURL = "https://qa.koel.app/";
        enterEmail("invalid@koel.io");
        enterPassword("te$t$tudent");
        submit();
        //Expected Results - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    //Negative Test Case 2
    @Test
    public void loginWithNoPassword() {
        //navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        enterEmail("invalid@koel.io");
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }
}



