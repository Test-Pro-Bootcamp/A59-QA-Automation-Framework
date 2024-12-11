import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageFactory.LoginPageFactory;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeWorkTest18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        // navigate to page
       // navigateToPage();
        //login
        loginPage.provideEmail("apurva.singh@testpro.io");
        loginPage.providePassword("te$tpro$tudent1");
        loginPage.clickSubmit();

        homePage.enterAllSongs();
       // Thread.sleep(1000);
        homePage.selectSong();
       // Thread.sleep(1000);
        allSongsPage.enterButtonPlaySong();
        //Thread.sleep(1000);
        allSongsPage.clickPlayNextBtn();
       // Thread.sleep(1000);

        assertTrue(homePage.isDisplayedPlayingSong());
    }
    }




