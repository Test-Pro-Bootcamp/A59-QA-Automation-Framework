import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.LoginPageFactory;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //login
        loginPage.provideEmail("apurva.singh@testpro.io");
        loginPage.providePassword("te$tpro$tudent1");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Steps
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.providePassword("te$tpro$tudent1");
        loginPage.clickSubmit();
        // Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), url); // https://qa.koel.app/
    }

    //@Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Steps
        loginPage.provideEmail("invalid@testpro.io");
        loginPage.clickSubmit();

        // Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/
    }

    //  @Test
    public void positiveLoginTest() throws InterruptedException {
        //objects
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //login
        loginPage.provideEmail("apurva.singh@testpro.io");
        loginPage.providePassword("te$tpro$tudent1");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
    // converting above test case in to page factory

    // @Test
    public void positiveLoginTestUsingPageFactory() throws InterruptedException {
        //objects
        //LoginPage loginPage = new LoginPage(driver);
        LoginPageFactory loginPageFactory = new LoginPageFactory(getDriver());
        HomePage homePage = new HomePage(getDriver());

        /*login
        loginPageFactory.provideEmail("apurva.singh@testpro.io");
        loginPageFactory.providePassword("te$tpro$tudent1");
        loginPageFactory.clickSubmitBtn();

         */
//or we can do like this if we replace loginPageFActory in place of void in LOginPAgeFActory class
        loginPageFactory.provideEmail("apurva.singh@testpro.io")
                .providePassword("te$tpro$tudent1")
                .clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }


}
