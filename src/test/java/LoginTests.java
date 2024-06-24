import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {


        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }

    //Happy Path-Login Test


    @Test
    public void loginValidEmailPassword(){


       // navigateToPage();
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
        //Thread. sleep(4000);
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));

        //Avatar Icon for Actual vs Expected
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit Browser

    }

    //Negative Test



    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        enterEmail("alekseikoksharov@testproio");
        enterPassword("ak1234!@#$");
        submit();
        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        //Quit

    }

    //Negative Test - empty password field


    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        enterEmail("aleksei.koksharov@testpro.io");
        submit();

        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);                 //https://qa.koel.app/

        //Quit

    }

    @Test(dataProvider = "NegativeLoginTestData" , dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {

        String expectedUrl = "https://qa.koel.app/";

        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);

    }

}
