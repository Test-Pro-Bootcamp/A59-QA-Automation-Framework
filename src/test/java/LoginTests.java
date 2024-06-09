import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {


        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    //Happy Path-Login Test
    @Test

    public void loginValidEmailPassword() throws InterruptedException {


        navigateToPage();
        Thread.sleep(2000);
        enterEmail("alekseikoksharov@testproio");
        Thread.sleep(2000);
        enterPassword("ak1234!@#$");
        Thread.sleep(2000);
        submit();
        Thread. sleep(4000);

        //Avatar Icon for Actual vs Expected
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit Browser

    }

    //Negative Test

    @Test

    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        navigateToPage();
        Thread.sleep(2000);
        enterEmail("alekseikoksharov@testproio");
        Thread.sleep(2000);
        enterPassword("ak1234!@#$");
        Thread.sleep(2000);
        submit();
        Thread. sleep(4000);

        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Quit

    }

    //Negative Test - empty password field
    @Test

    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage();
        Thread.sleep(2000);
        enterEmail("alekseikoksharov@testproio");
        Thread.sleep(2000);
        submit();
        Thread.sleep(4000);

        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Quit

    }


}
