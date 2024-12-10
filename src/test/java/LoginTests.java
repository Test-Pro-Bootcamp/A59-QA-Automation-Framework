import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {


        enterEmail("apurva.singh@testpro.io");
        enterPassword("te$tpro$tudent1");
        submit();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {



        // Steps
        enterEmail("invalid@testpro.io");
        enterPassword("te$tpro$tudent1");
        submit();

       // Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {


        enterEmail("invalid@testpro.io");
        submit();

       // Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }
    //login test using page object model
    @Test
    public void positiveLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        // steps
        loginPage.provideEmail("apurva.singh@testpro.io");
        loginPage.providePassword("te$tpro$tudent1");
        loginPage.clickSubmit();

        //Expected
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}