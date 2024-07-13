import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
//import page.LoginPage;
import pageFactory.LoginPage;

public class LoginTest extends BaseTest {


    @Test
    public void loginEmptyEmailPassword() {
// GIVEN: User is on the login page
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

// WHEN: User login with empty email and valid password and clicks submit
        loginPage.provideEmail(" ").provideEmail("jKV0uSX6z1dv").clickSubmit();

// THEN : User should not be able to login and remain on the login page
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        driver.quit();

    }

    @Test

    public void loginValidEmailPassword() {

// GIVEN: User is on the login page
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

// WHEN: User login in with valid email and password and clicks submit
        loginPage.provideEmail("christina.taylor@testpro.io").providePassword("jKV0uSX6z1dv").clickSubmit();


// GIVEN: User should be given access and home page is displayed
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());


    }

    @Test

    public void loginInvalidEmailValidPassword() {

//Given: User is on the login page
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

//WHEN: User login with invalid email and valid password and clicks submit

        loginPage.provideEmail("invalidemail@testpro.io").providePassword("jKV0uSX6z1dv").clickSubmit();

// THEN:User should not be able to login and remain on the login page
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }

    @Test

    public void loginEmailEmptyPassword() {

// GIVEN: User is on login page
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

// WHEN: User login with valid email and empty password and clicks submit
        loginPage.provideEmail("christina.taylor@testpro.io").providePassword(" ").clickSubmit();

//THEN: User should not be able to login and remain on the login page
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);




    }

    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void loginNegativeTest(String email, String password) throws InterruptedException {

// GIVE: User is on  login page
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

// GIVEN: User is providing a mix of not valid email and password and clicks submit
        loginPage.login();


//THEN: User should not be able to login and remain on the login page
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


    }

}


