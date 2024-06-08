import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest{



    @Test
    public void playSong(){
       // navigateToPage();
        enterEmail();
        enterPassword();
        submit();
        clickPlayNext();
        validateSongPlaying();

    }

public void clickPlayNext(){
    WebElement nextSongBtn = driver.findElement(By.xpath("//i[@title='Play next song']"));
    nextSongBtn.click();

}

public void validateSongPlaying(){
    WebElement soundBar = driver.findElement(By.xpath("//div[@class='plyr__progress']"));
    Assert.assertTrue(soundBar.isDisplayed());


}
}