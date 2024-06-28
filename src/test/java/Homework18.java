import io.netty.util.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {
    private WebElement playNextButton;
    private WebElement driver;

    @Test
    public void playSong(){
     login("india.messam@testpro.io", "slcTalgy");

 }

    private void login(String mail, String slcTalgy) {

    }

    //Return to work on this over the weekend
 public void clickPlay(){
     //@FindBy(xpath ="//i[@data-testid='play-next-btn']" )
             WebElement playNextBtn;
     //WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
     //@FindBy(xpath = "//[@data-testid='play-btn']")
             WebElement playBtn;
     //WebElement playButton = driver.findElement(By.xpath("//[@data-testid='play-btn']"));

     playNextButton.click();
     WebElement playButton = null;
     playButton.click();
 }
 public boolean isSongPlaying(){
     WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
     return soundBar.isDisplayed();

    }
}
