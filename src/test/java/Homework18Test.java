import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18Test extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {

 navigateToPage();
 enterEmail("kristina.sarkisyan@testpro.io");
 enterPassword("o8URUDnW");
 submit();
 playNextSong();
 Thread.sleep(2000);
 playBtn();
 Thread.sleep(2000);
 WebElement pauseBtn = driver.findElement(By.xpath("//footer[@id='mainFooter']/div[@class='side player-controls']/span[@class='album-thumb-wrapper']/span[@data-testid='pause-btn']/i[@class='fa fa-pause']"));
 Assert.assertTrue(pauseBtn.isDisplayed(),"Pause button is not displayed, indicating song is not playing.");
 closeBrowser();
 }

    public void playBtn() {
        WebElement clickPlayBtn = driver.findElement(By.xpath("//footer[@id='mainFooter']/div[@class='side player-controls']/span[@class='album-thumb-wrapper']/span[@data-testid='play-btn']/i[@class='fa fa-play']"));
        clickPlayBtn.click();
    }

    public void playNextSong() {
        WebElement clickPlayNextSong = driver.findElement(By.xpath("//footer[@id='mainFooter']//i[@title='Play next song']"));
        clickPlayNextSong.click();
    }

}

