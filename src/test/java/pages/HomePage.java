package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);


    }
    //page element

    By userAvatarIcon = By.cssSelector("img.avatar");
    // helper method
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);

    }
    public void navigateToChooseAllSongs() {
        wait.until (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

    }
    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongElement).perform();
    }
    public void enterAllSongs() throws InterruptedException {
        WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/songs']")));
        //Thread.sleep(1000);
        allSongs.click();
    }
    public void selectSong() {
        WebElement song =  wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]")));
        song.click();
    }
  public boolean isDisplayedPlayingSong() {
        WebElement songIsPlaying = driver.findElement(By.xpath("//span[@title='Pause']"));
        return songIsPlaying.isDisplayed();
    }
}
