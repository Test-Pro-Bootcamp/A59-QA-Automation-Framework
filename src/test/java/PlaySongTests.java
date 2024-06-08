import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTests extends BaseTest {

    @Test
    public void playSongs() throws InterruptedException {

        String expectedMessage = null;

        //Standard procedures
        navigateToPage();
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
        Thread.sleep(3000);
        playNextSongBtn();
        playSongBtn();
        findSoundBars();
     //   Assert.assertEquals(findSoundBars(), expectedMessage);
    }

    public void playNextSongBtn() throws InterruptedException {
        WebElement playNextSong = driver.findElement(By.xpath("//i[@role=\"button\"][@title=\"Play next song\"][@data-testid=\"play-next-btn\"]"));

    //    System.out.println("Begin");
    //    System.out.println(playNextSong.toString());
    //    System.out.println("End");

        playNextSong.click();

        Thread.sleep(3000);
    }
    public void playSongBtn() throws InterruptedException {
        WebElement playSong = driver.findElement(By.xpath("//span[@title=\"Play or resume\"][@data-testid=\"play-btn\"]//i[@class=\"fa fa-play\"]"));

    //    System.out.println("Begin");
    //    System.out.println(playSong.toString());
    //    System.out.println("End");

        playSong.click();

        Thread.sleep(3000);
    }

    public void findSoundBars() throws InterruptedException {
        WebElement verifySoundBar = driver.findElement(By.xpath("//div[@data-test=\"soundbars\"]"));
        System.out.println("Begin");
        System.out.println(verifySoundBar.toString());
        if (verifySoundBar.toString() != null) {
            System.out.println("Successfully Playing Song");
        } else {
            System.out.println("Failed to Play Song");
        }
        System.out.println("End");
    }
}
