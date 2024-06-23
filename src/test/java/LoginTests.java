import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert; import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);


    @Test
    public void loginEmptyEmailPassword() {

        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();


        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}