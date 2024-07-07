import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmptyEmailPassword();
        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }

    @Test
    public void loginValidEmailPassword(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //Negative Test
    @Test
    public void loginWithInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInvalidEmail();
        String expectedUrl = "https://qa.koel.app/";
//        enterEmail("alekseikoksharov@testproio");
//        enterPassword("ak1234!@#$");
//        submit();
        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    //Negative Test - empty password field
    @Test
    public void loginValidEmailEmptyPassword()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginEmptyPassword();
        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
//        enterEmail("aleksei.koksharov@testpro.io");
//        submit();
        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);                 //https://qa.koel.app/
    }

    @Test(dataProvider = "NegativeLoginTestData" , dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {


        String expectedUrl = "https://qa.koel.app/";


        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
}
