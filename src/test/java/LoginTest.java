import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {


        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {


        Thread.sleep(2000);
        navigateToPage();
        Thread.sleep(2000);
        enterEmail(email);
        Thread.sleep(2000);
        enterPassword(password);
        Thread.sleep(2000);

        submit();
        Thread.sleep(2000);

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar"));
        Thread.sleep(2000);
        Assert.assertTrue(avatarIcon.isDisplayed());



    }


    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {


        Thread.sleep(2000);
        navigateToPage();
        Thread.sleep(2000);

        enterEmail("invalid@testpro.io");

        Thread.sleep(2000);

        enterPassword("jKV0uSX6z1dv");
        Thread.sleep(2000);

        submit();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), url);



    }


    @Test
    public void loginEmailEmptyPassword() throws InterruptedException {



        navigateToPage();
        Thread.sleep(2000);
        enterEmail("christina.taylor@testpro.io");
        Thread.sleep(2000);
        submit();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), url);


    }

}


