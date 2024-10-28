import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        // Step 1 - navigate to koel app page

        //navigateToPage();

        Thread.sleep(1000);

        // Step 2 - login
        enterEmail("leon.poyau@testpro.io");
        enterPassword("jTRCkwNf");
        submit();
        Thread.sleep(1000);


        // Step 3 - Play next song
        playNextSong();
        Thread.sleep(4000);

        // validate a song is playing by verifying soundbar is displayed via assertion
        WebElement sndBar = driver.findElement(
                By.xpath("//footer[@id='mainFooter']//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(sndBar.isDisplayed());


    }

    public void playNextSong() {

        // locate play next song button and click it.
        WebElement playNextBtn = driver.findElement(By.xpath
                ("//footer[@id='mainFooter']//i[@class='next fa fa-step-forward control']"));
        playNextBtn.click();
        // locate play button and click it.
        WebElement playBtn = driver.findElement(By.xpath
                ("//footer[@id='mainFooter']//span[@data-testid='play-btn']"));
        playBtn.click();
    }

}
