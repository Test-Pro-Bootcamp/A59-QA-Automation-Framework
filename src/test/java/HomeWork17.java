import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest{
@Test
  public void  addSongToPlaylist(){

  String expectedAddedSongMsg = "Added 1 song into \"NewPlaylist.\"";
  //navigateToPage();
  enterEmail(email);
  enterPassword(password);
  submit();
  searchSong("dark");
  selectSong();
  selectPlaylist();
  Assert.assertEquals(getPlaylistSuccessMsg(), expectedAddedSongMsg);


    }

    public void searchSong(String songName){
      WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));

      searchField.clear();
      searchField.sendKeys(songName);
      WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
      viewAllBtn.click();
    }

    public void selectSong (){
  WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
          ("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
  firstSong.click();
  WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test=\"add-to-btn\"]")));
  addToBtn.click();
    }

    public void selectPlaylist(){
  WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable
          (By.xpath("//*[@id=\"songResultsWrapper\"]//li[contains(text(), \"NewPlaylist\")]")));
  playlist.click();
    }

    public String getPlaylistSuccessMsg(){
  WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
  return notification.getText();
    }
}
