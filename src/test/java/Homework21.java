import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.bouncycastle.cms.RecipientId.password;

public class Homework21 extends BaseTest {
    WebDriverWait wait;
    Actions actions;
    @Test
    public void renamePlaylist() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //login
        // enterEmail("apurva.singh@testpro.io");
        //enterPassword("te$tpro$tudent1");
        //submit();
        loginPage.login();
        // create a new playlist
        homePage.createPlaylistAction();
        //Thread.sleep(5000);
        //rename a new playlist
       homePage.renamePlaylistAction();
        //  Thread.sleep(5000);
        //Assert
        Assert.assertTrue(homePage.getSuccessPopUp().isDisplayed());
        // Quitting the WebDriver session
        driver.quit();

    }

    }





