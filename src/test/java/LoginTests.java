import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {


        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

    }



    @Test
    public void loginValidEmailPassword() throws InterruptedException {


        navigateToPage();
        enterEmail("demo@gmail.com");
        enterPassword("te$t$tudant");
        submit();



        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));



        Assert.assertTrue(avatarIcon.isDisplayed());


    }

    //Negation Testing
    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {


        navigateToPage();
        enterEmail("invalid@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        Thread.sleep(4000);

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage();
        enterEmail("invalid@testpro.io");
        submit();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
