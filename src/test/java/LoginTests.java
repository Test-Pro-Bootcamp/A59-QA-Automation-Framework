import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

    //  Before we can use LoginPage objects, we have to create a new instance of that object
    //  So we need a new constructor that enables us to use those pages object
        LoginPage loginPage = new LoginPage(driver);

        HomePage homePage = new HomePage(driver);

    //  loginPage.login();

    //  Expected Result
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test (enabled = false)
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        // Steps
        enterEmail("invalid@testpro.io");
        enterPassword("te$t$tudent");
        submit();

    //  Thread.sleep(1000); // Sleep or pause for 2 seconds (adjust as needed)
    //  Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
    }

    @Test (enabled = false)
    public void loginValidEmailEmptyPassword() throws InterruptedException {

   //   navigateToPage();
        enterEmail("invalid@testpro.io");
        submit();

    //  Thread.sleep(1000); // Sleep or pause for 2 seconds (adjust as needed)
    //  Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

    @Test (enabled = false, dataProvider = "IncorrectLoginData", dataProviderClass = TestDataProvider.class)
    public void loginEmptyEmailPassword(String email, String password) throws InterruptedException {

    //  navigateToPage();
        enterEmail(email);
        enterPassword(password);
        submit();
    //  Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/

    }
}