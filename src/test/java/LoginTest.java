import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        navigateToPage();
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();



        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());


    }

    @Test

    public void loginInvalidEmailValidPassword() throws InterruptedException {

        navigateToPage();
        enterEmail("invalid@testpro.io");
        enterPassword("te$t$tudent");

        Thread.sleep(2000);

        submit();

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), url);


    }


    @Test

    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage();

        enterEmail("demo@testpro.io");

        submit();

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), url);

        Thread.sleep(2000);


    }


}




