import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static sun.security.jgss.GSSUtil.login;

public class Homework18 extends BaseTest {


    @Test(priority = 1, description = "playa song and validate the a song is playing")
    public void playSong() throws InterruptedException {


        navigateToPage();
        enterEmail("christina.taylor@testpro.io");
        enterPassword("jKV0uSX6z1dv");
        submit();


        enterButtonPlay();
        selectSongs();

        enterAllSongs();

    }

    private void enterButtonPlay() {
        WebElement buttonPlay = driver.findElement(By.xpath("//span[@title='Play or resume;]"));
    }

    private void selectSongs() {
        WebElement song = driver.findElement(By.xpath("//tr[@class='songs']"));
        song.click();
    }

    public void enterAllSongs() {
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        allSongs.click();

    }


    }



// old  homework

/*
//Navigate to "https://qa.koel.app/".
        navigateToPage();
        enterEmail("christina.taylor@testpro.io");
        enterPassword("jKV0uSX6z1dv");
        submit();



        //Click «Play next song» (media player controls),
        selectSong();
        Thread.sleep(1000);
        // then the Play button, to play a song.
        clickPlayNext();
        Thread.sleep(1000);
        // or the pause button is displayed.
        clickPauseBtn();
        Thread.sleep(1000);


    }

    private void selectSong() {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        song.click();
    }

    public void clickPauseBtn() {
        WebElement pauseBtn = driver.findElement(By.cssSelector("//span[@title='Play or resume']"));
        pauseBtn.click();
    }

    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector("//span[@title='Play or resume']"));
        playBtn.click();
    }

    private void clickPlayNext() {
        WebElement playNext = driver.findElement(By.cssSelector("[class='next fa fa-step-forward control']"));
        playNext.click();
    }
}
