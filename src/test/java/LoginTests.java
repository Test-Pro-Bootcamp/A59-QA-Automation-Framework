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

    //Happy Path - Login Test
    @Test
    public void loginValidEmailValidPassword() throws InterruptedException {

       //Step1
        navigateToPage();
        Thread.sleep(2000);
        //Step2
        enterEmail(email);
        Thread.sleep(2000);
        //Step3
        enterPassword(password);
        Thread.sleep(2000);
        //Step4
        submit();
        Thread.sleep(4000);
        //Step5
        //Avatar Icon for Actual vs Expected
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    // Not a Happy Path - Negative Path
    @Test

    public void loginWithInvalidEmailValidPassword() throws InterruptedException {

        //Step1
        navigateToPage();
        Thread.sleep(2000);
        //Step2
        enterEmail("invalid@koel.io");
        //Step3
        enterPassword(password);
        Thread.sleep(2000);
        //Step4
        submit();
        Thread.sleep(4000);
        //Expected Results - Assertions (URL should stay the same)
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginWithValidEmailEmptyPassword() throws InterruptedException {
        navigateToPage();
        enterEmail(email);
        submit();

        Thread.sleep(2000); //sleep or pause for 2 seconds (adjust as needed)
        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

}
