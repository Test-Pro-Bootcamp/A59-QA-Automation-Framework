import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
//Homework 16

public class RegistrationTest extends BaseTest {


    @Test
    public void registrationNavigation() {

        String url = "https://qa.koel.app/";
        String urlRegistration = "https://qa.koel.app/registration";

        loginPage.clickRegistrationLink();
        Assert.assertEquals(driver.getCurrentUrl(), urlRegistration);

//      Added ChromeOptions argument below to fix websocket error
    //Step 1
//        String url = "https://qa.koel.app/";
//        driver.get(url);
//
//
//        //Step 2
//        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
//        registrationLink.click();
//
//
//
//        //Step 3
//        String urlRegistration = "https://qa.koel.app/registration";
//        Assert.assertEquals(driver.getCurrentUrl(), urlRegistration);
//        driver.quit();
}
}

