import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class LoginTests extends BaseTest {



    @Test (enabled = false)
    public void loginValidEmailPassword() throws InterruptedException {

     //   navigateToPage();
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
    //    WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test (enabled = false)
    public void loginInvalidEmailValidPassword() throws InterruptedException {

     //   navigateToPage();

        // Steps
        enterEmail("invalid@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        Thread.sleep(1000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
    }

    @Test (enabled = false)
    public void loginValidEmailEmptyPassword() throws InterruptedException {
      //  navigateToPage();
        enterEmail("invalid@testpro.io");
        submit();

        Thread.sleep(1000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = TestDataProvider.class)
    public void loginEmptyEmailPassword(String email, String password) throws InterruptedException {
      //  navigateToPage();
        enterEmail(email);
        enterPassword(password);
        submit();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/

    }
}