import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{


    @Test
    public void playSong() throws InterruptedException {


        //Navigate to "https://qa.koel.app/".
        navigateToPage();
        //Log in
        enterEmail("christina.taylor@testpro.io");
        enterPassword("jKV0uSX6z1dv");
        submit();
        Thread.sleep(1000);
        //Click «Play next song» (media player controls),
        clickPlayBtn();
        Thread.sleep(1000);
        // then the Play button, to play a song.
        clickPlayNext();
        Thread.sleep(1000);
        // or the pause button is displayed.
        clickPauseBtn();
        Thread.sleep(1000);








    }

    public void clickPauseBtn() {
        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        pauseBtn.click();
    }

    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();
    }

    private void clickPlayNext() {
        WebElement playNext = driver.findElement(By.cssSelector("[class='next fa fa-step-forward control']"));
        playNext.click();
    }
}
