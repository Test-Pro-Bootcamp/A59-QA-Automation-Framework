
    /*import org.testng.Assert;
    import org.testng.annotations.Test;
    import pgFactoryPages.LoginPage;

public class LoginTests extends BaseTest {


    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!"); // Calling the login method from LoginPage
    }
  //@Test (dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(getDriver().getCurrentUrl(),expectedUrl);
  }
}

 */
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.testng.Assert;
    import org.testng.annotations.Test;
    import pgFactoryPages.HomePage;
    import pgFactoryPages.LoginPage;


    public class LoginTests extends BaseTest {

        @Test
        public void loginValidEmailPassword() throws InterruptedException{
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            loginPage.provideEmail("giovanna.silva@testpro.io");
            loginPage.providePassword("ShakaMaya1302!");
            loginPage.clickSubmit();
            Thread.sleep(1000);
            //Assert.assertTrue(homePage.isUserAvatarDisplayed());
           // Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

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
            Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); // https://qa.koel.app/
        }

        // @Test
        public void loginValidEmailEmptyPassword() throws InterruptedException {

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
