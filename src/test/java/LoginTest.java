import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {


//@Test
    public void loginEmptyEmailPassword() throws InterruptedException {

        String expectedURL= "https://qa.koel.app/";
        //navigateToPage();
        enterEmail("");
        enterPassword("jKV0uSX6z1dv");
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        driver.quit();
    }
@Test

    public void loginValidEmailPassword() throws InterruptedException {

//code from Page Objects
//the codes are being pulled to use here.
   LoginPage loginPage = new LoginPage(driver);
   HomePage homePage = new HomePage(driver);

   // login has step in it with a method

 loginPage.login();

 Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());







/*
        enterEmail("christina.taylor@testpro.io");

        enterPassword("jKV0uSX6z1dv");


        submit();

    WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.cssSelector("img[class='avatar']")));
       // WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

        Assert.assertTrue(avatarIcon.isDisplayed());


*/
    }

//@Test

    public void loginInvalidEmailValidPassword() throws InterruptedException {



       // navigateToPage();

        String expectedURL= "https://qa.koel.app/";
        enterEmail("invalid@testpro.io");

        enterPassword("jKV0uSX6z1dv");


        submit();


        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);



    }

//@Test

    public void loginEmailEmptyPassword() throws InterruptedException {



      //  navigateToPage();
        String expectedURL= "https://qa.koel.app/";
        enterEmail("christina.taylor@testpro.io");

        submit();


        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


    }
    //@Test( dataProvider ="NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void loginNegativeTest(String email, String password) throws InterruptedException {

        String expectedURL= "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);


    }

}


