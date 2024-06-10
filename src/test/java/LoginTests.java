import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error

            String url = "https://qa.koel.app/";
            driver.get(url);
            enterEmail("");
            enterPassword("");
            submit();
            Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void validLogin() {
        String url = "https://qa.koel.app/#!/home";
        driver.get(url);
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailInvalidPassword() {
        String url = "https://qa.koel.app/";
        driver.get(url);
        enterEmail(email);
        enterPassword("teststudent");
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        String url = "https://qa.koel.app/";
        driver.get(url);
        enterEmail("email");
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}