
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;



        public class LoginTests extends BaseTest {


            @Test
            public void loginValidEmailPassword() throws InterruptedException {
                LoginPage loginPage = new LoginPage(getDriver());
                HomePage homePage = new HomePage(getDriver());
                loginPage.provideEmail("demo@testpro.io");
                loginPage.providePassword("te$t$tudent");
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