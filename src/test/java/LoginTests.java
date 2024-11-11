import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        navigateToPage();
        enterEmail("apurva.singh@testpro.io");
        enterPassword("te$tpro$tudent1");
        submit();
        //Thread.sleep(2000);
        // instead of thread.sleep the better practice is to use the below line.
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
       // WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // and better option in one line is to club the above line with wait.until line is =
        WebElement avatarIcon = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        navigateToPage();

        // Steps
        enterEmail("invalid@testpro.io");
        enterPassword("te$tpro$tudent1");
        submit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage();
        enterEmail("invalid@testpro.io");
        submit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }
}