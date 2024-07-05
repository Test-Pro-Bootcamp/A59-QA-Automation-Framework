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


        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }

    @Test
    public void loginValidEmailPassword(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


//        loginPage.provideEmail("aleksei.koksharov@testpro.io");
//        loginPage.providePassword("ak1234!@#$");
//        loginPage.clickSubmit();
        //   ---------OR--------
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
//       // navigateToPage();
//        enterEmail("aleksei.koksharov@testpro.io");
//        enterPassword("ak1234!@#$");
//        submit();
//        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
//
//        //Avatar Icon for Actual vs Expected
//        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
//
//        //Assertions - Expected vs Actual
//        Assert.assertTrue(avatarIcon.isDisplayed());
         //Quit Browser
    }

    //Negative Test
    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);


        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
//        enterEmail("alekseikoksharov@testproio");
//        enterPassword("ak1234!@#$");
//        submit();
        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        //Quit
    }

    //Negative Test - empty password field
    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);


        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
//        enterEmail("aleksei.koksharov@testpro.io");
//        submit();

        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);                 //https://qa.koel.app/

        //Quit
    }

    //@Test(dataProvider = "NegativeLoginTestData" , dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);


        String expectedUrl = "https://qa.koel.app/";

//        enterEmail(email);
//        enterPassword(password);
//        submit();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
}
