import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Homework18 extends BaseTest {

    @Test

    public void playSong(){


        //navigateToPage();
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
        driver.manage().window().maximize();
        enterAllSongs();
        //from Home page click play button
        clickPlayBtn();
        //Assertions - Expected vs Actual
        Assert.assertTrue(isDisplayedSoundBar());
    }//

    private boolean isDisplayedSoundBar() {
        WebElement soundBar = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        return soundBar.isDisplayed();
    }

    private void enterAllSongs() {
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        allSongs.click();
    }


    public void clickPlayBtn() {
            WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.play")));
            //WebElement playBtn = driver.findElement(By.cssSelector("span.play"));
            Actions actions = new Actions(driver);
            actions.click(playBtn).perform();

        }



    }