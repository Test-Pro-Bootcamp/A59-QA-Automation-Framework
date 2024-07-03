import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        // navigateToPage();
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    // @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        // navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        // Steps
        enterEmail("invalid@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL); // https://qa.koel.app/
    }

    // @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        // navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        enterEmail("invalid@testpro.io");
        submit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL); //https://qa.koel.app/
    }

    @Test(dataProvider="NegativeLoginTestData")
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedURL = "https://qa.koel.app/";
        enterEmail(email);
        enterEmail(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
}