import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
//import page.LoginPage;
import pageFactory.LoginPage;

public class LoginTest extends BaseTest {


@Test
    public void loginEmptyEmailPassword()  {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();



        String expectedURL= "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        driver.quit();
        /*
        String expectedURL= "https://qa.koel.app/";
        //navigateToPage();
        enterEmail("");
        enterPassword("jKV0uSX6z1dv");

 */
    }
@Test

    public void loginValidEmailPassword()  {

//code from Page Objects
//the codes are being pulled to use here.
   LoginPage loginPage = new LoginPage(driver);
   HomePage homePage = new HomePage(driver);

   // login has step in it with a method

loginPage.provideEmail("christina.taylor@testpro.io").providePassword("jKV0uSX6z1dv").clickSubmit();

 Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());










    }

@Test

    public void loginInvalidEmailValidPassword()  {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

       loginPage.login();


    loginPage.provideEmail("christina.taylor@test.io");
    loginPage.providePassword("jKV0uSX6z1dv");


    String expectedURL= "https://qa.koel.app/";


        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    // enterEmail("christina.taylor@test.io");
    //  enterPassword("jKV0uSX6z1dv");

    }

@Test

    public void loginEmailEmptyPassword()  {



     LoginPage loginPage = new LoginPage(driver);
     HomePage homePage =new HomePage(driver);

     loginPage.provideEmail("christina.taylor@testpro.io");
     loginPage.providePassword(" ");



        String expectedURL= "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


    //  enterEmail("christina.taylor@testpro.io");


    }
    @Test( dataProvider ="NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void loginNegativeTest(String email, String password) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePAge = new HomePage(driver);


        loginPage.login();

        String expectedURL= "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

         /*  enterEmail(email);
        enterPassword(password);
        submit();

       */


    }

}


